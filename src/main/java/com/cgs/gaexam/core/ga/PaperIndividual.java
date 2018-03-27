package com.cgs.gaexam.core.ga;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cgs.gaexam.core.ServiceException;
import com.cgs.gaexam.model.Question;
import com.cgs.gaexam.model.QuestionType;
import com.cgs.gaexam.model.Rule;
import com.cgs.gaexam.model.dto.QuestionInfo;
import com.cgs.gaexam.service.QuestionService;
import com.cgs.gaexam.service.QuestionTypeService;
import com.cgs.gaexam.utils.SpringUtil;
import com.cgs.gaexam.utils.ValueUtil;
import tk.mybatis.mapper.entity.Condition;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 试卷个体
 */
public class PaperIndividual {

    private QuestionService questionService = SpringUtil.getBean(QuestionService.class);
    private QuestionTypeService questionTypeService = SpringUtil.getBean(QuestionTypeService.class);

    /**
     * 个体id
     */
    private int id;
    /**
     * 适应度
     */
    private Float adaptationDegree;
    /**
     * 知识点覆盖率
     */
    private Float knowledgeCoverage;
    /**
     * 试卷实际包含的知识点id序列，格式1,2,3
     */
    private String actknowledgeIds;
    /**
     * 试卷总分
     */
    private Float totalScore;
    /**
     * 试卷难度系数
     */
    private Float difficulty;
    /**
     * 个体包含的试题集合
     */
    private List<QuestionInfo> questionList;

    public PaperIndividual(int size) {
        questionList = new ArrayList<QuestionInfo>();
        for (int i = 0; i < size; i++) {
            questionList.add(null);
        }
    }

    public PaperIndividual() {
        super();
        questionList = new ArrayList<>();
        adaptationDegree = 0.00F;
        knowledgeCoverage = 0.00F;
        totalScore = 0.00F;
        difficulty = 0.00F;
    }

    /**
     * 计算试卷试题总分
     *
     * @return
     */
    public Float getTotalScore() {
        if (Float.compare(totalScore, 0.00F) == 0 && questionList.size() > 0) {
            float total = 0.00F;
            for (QuestionInfo question : questionList) {
                total += question.getScore();
            }
            totalScore = ValueUtil.round2Decimals(total);
        }
        return totalScore;
    }

    /**
     * 计算试卷个体难度系数 计算公式： 每题难度*分数求和除总分
     *
     * @return
     */
    public float getDifficulty() {
        if (Float.compare(difficulty, 0.00F) == 0) {
            float tmpDifficulty = 0.00F;
            for (QuestionInfo question : questionList) {
                tmpDifficulty += question.getScore() * question.getDifficulty();
            }
            difficulty = ValueUtil.round2Decimals(tmpDifficulty / getTotalScore());
        }
        return difficulty;
    }

    /**
     * 获取试题数量
     *
     * @return
     */
    public int getQuestionNumber() {
        return questionList.size();
    }

    /**
     * 计算知识点覆盖率 公式为：个体包含的知识点/期望包含的知识点
     *
     * @param
     */
    public void setKnowledgeCoverage(Rule rule) {
        if (Float.compare(knowledgeCoverage, 0.00F) == 0) {
            Set<String> knowledgeSet = new HashSet<String>();
            String[] expKnowledgeIds = rule.getExpKnowledgeIds().split(",");
            knowledgeSet.addAll(Arrays.asList(expKnowledgeIds));

            Set<String> actKnowledgeSet = new HashSet<>();
            questionList.stream().forEach(questionInfo -> {
                actKnowledgeSet.addAll(Arrays.asList(questionInfo.getKnowledgeIds().split(",")));
            });
            String actKnowledgeStr = actKnowledgeSet.toString();
            this.setActknowledgeIds(actKnowledgeStr.substring(1, actKnowledgeStr.indexOf("]")));
            // 交集操作
            knowledgeSet.retainAll(actKnowledgeSet);
            //保留两位小数
            knowledgeCoverage = ValueUtil.round2Decimals((float) knowledgeSet.size() / expKnowledgeIds.length);
        }
    }

    /**
     * 计算个体适应度 公式为：f=1-(1-M/N)*w1-|EP-P|*w2
     * 其中M/N为知识点覆盖率，EP为期望难度系数，P为种群个体难度系数，w1为知识点分布的权重
     * ，w2为难度系数所占权重。当w1=0时退化为只限制试题难度系数，当w2=0时退化为只限制知识点分布
     *
     * @param rule 组卷规则
     * @param w1   知识点分布的权重
     * @param w2   难度系数的权重
     */
    public void setAdaptationDegree(Rule rule, float w1, float w2) {
        if (Float.compare(adaptationDegree, 0.00F) == 0) {
            adaptationDegree = ValueUtil.round2Decimals(1 - (1 - getKnowledgeCoverage()) * w1 - Math.abs(rule.getExpDifficulty() - getDifficulty()) * w2);
        }
    }

    public boolean containsQuestion(QuestionInfo question) {
        if (question != null) {
            for (QuestionInfo questionInfo : questionList) {
                if (questionInfo != null) {
                    if (questionInfo.getId().equals(question.getId())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 生成试题
     *
     * @param rule
     */
    public void generateQuestion(Rule rule) {
        Random random = new Random();
        JSONArray questionTypeInfoList = JSONArray.parseArray(rule.getQuestionInfo());
        if (questionTypeInfoList.size() > 0) {
            for (int i = 0; i < questionTypeInfoList.size(); i++) {
                JSONObject questionTypeInfo = questionTypeInfoList.getJSONObject(i);
                long questionType = questionTypeInfo.getLong("typeId");
                int score = questionTypeInfo.getInteger("score");
                int number = questionTypeInfo.getInteger("number");
                String typeName = questionTypeInfo.getString("typeName");

                QuestionInfo[] questionList = questionService.find(questionType, rule.getCourseId(), rule.getExpKnowledgeIds());
                QuestionInfo tmpQuestion;
                int questionListLength = questionList.length;
                if (questionListLength < number) {
                    throw new ServiceException("题库" + typeName + "数量不够，组卷失败！");
                }
                for (int j = 0; j < number; j++) {
                    int index = random.nextInt(questionListLength - j);
                    // 初始化分数
                    questionList[index].setScore(score);
                    //按照各题型的顺序存储题目
                    this.addQuestion(questionList[index]);
                    // 保证不会重复添加试题
                    tmpQuestion = questionList[questionListLength - j - 1];
                    questionList[questionListLength - j - 1] = questionList[index];
                    questionList[index] = tmpQuestion;
                }
            }
        }
    }

    public String getQuestionIds() {
        if (questionList != null && getQuestionNumber() > 0) {
            String questionIds = questionList
                    .stream()
                    .map(questionInfo -> questionInfo.getId())
                    .collect(Collectors.toList())
                    .toString();
            return questionIds.substring(1, questionIds.indexOf("]"));
        }
        return null;
    }

    /**
     * 是否包含主观题，即是否需要阅卷
     *
     * @return
     */
    public Byte isSubjective() {
        Set<Long> typeIds = questionList
                .stream()
                .map(questionInfo -> questionInfo.getQuestionTypeId())
                .collect(Collectors.toSet());
        Condition condition = new Condition(QuestionType.class);
        condition.createCriteria().andEqualTo("subjective", 1);
        Set<Long> subTypeIds = questionTypeService.findByCondition(condition)
                .stream()
                .map(questionType -> questionType.getId())
                .collect(Collectors.toSet());
        for (Long typeId : subTypeIds) {
            if (typeIds.contains(typeId))
                return 1;
        }
        return 0;
    }

    /**
     * 增加试题
     *
     * @param question
     */
    public void saveQuestion(int index, QuestionInfo question) {
        this.questionList.set(index, question);
        this.totalScore = 0.00F;
        this.adaptationDegree = 0.00F;
        this.difficulty = 0.00F;
        this.knowledgeCoverage = 0.00F;
    }

    public void addQuestion(QuestionInfo question) {
        this.questionList.add(question);
        this.totalScore = 0.00F;
        this.adaptationDegree = 0.00F;
        this.difficulty = 0.00F;
        this.knowledgeCoverage = 0.00F;
    }

    public void clearQuestionList() {
        this.questionList.clear();
    }

    public QuestionInfo getQuestion(int index) {
        return questionList.get(index);
    }

    public long getQuestionType(int index) {
        return questionList.get(index).getQuestionTypeId();
    }

    public int getId() {
        return id;
    }

    public Float getAdaptationDegree() {
        return adaptationDegree;
    }

    public Float getKnowledgeCoverage() {
        return knowledgeCoverage;
    }

    public List<QuestionInfo> getQuestionList() {
        return questionList;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuestionList(List<QuestionInfo> questionList) {
        this.questionList = questionList;
    }

    public String getActknowledgeIds() {
        return actknowledgeIds;
    }

    public void setActknowledgeIds(String actknowledgeIds) {
        this.actknowledgeIds = actknowledgeIds;
    }

    @Override
    public String toString() {
        return "PaperIndividual{" +
                "questionService=" + questionService +
                ", id=" + id +
                ", adaptationDegree=" + adaptationDegree +
                ", knowledgeCoverage=" + knowledgeCoverage +
                ", totalScore=" + totalScore +
                ", difficulty=" + difficulty +
                ", questionList=" + questionList +
                '}';
    }

    public static void main(String[] args) {
        String questionInfo = "[\n" +
                "        {\n" +
                "            \"typeId\":1,\n" +
                "            \"typeName\":\"单选题\",\n" +
                "            \"number\":\"2\",\n" +
                "            \"score\":\"2\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"typeId\":2,\n" +
                "            \"typeName\":\"多选题\",\n" +
                "            \"number\":\"2\",\n" +
                "            \"score\":\"2\"\n" +
                "        }\n" +
                "    ]";
        JSONArray questionTypeInfoList = JSONArray.parseArray(questionInfo);

        if (questionTypeInfoList.size() > 0) {
            for (int i = 0; i < questionTypeInfoList.size(); i++) {
                JSONObject questionTypeInfo = questionTypeInfoList.getJSONObject(i);
                int questionType = questionTypeInfo.getInteger("typeId");
                int score = questionTypeInfo.getInteger("score");
                int num = questionTypeInfo.getInteger("number");
                String typeName = questionTypeInfo.getString("typeName");
                System.out.println(questionType + "," + num + "," + score + "," + typeName);
//                Set<Map.Entry<String, Object>> set = questionTypeInfo.entrySet();
//                set.stream().forEach(stringObjectEntry -> {
//                    System.out.println(stringObjectEntry.getKey() + ":" + stringObjectEntry.getValue());
//                });
            }
        }
    }
}
