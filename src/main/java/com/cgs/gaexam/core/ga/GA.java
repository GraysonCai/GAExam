package com.cgs.gaexam.core.ga;

import com.cgs.gaexam.core.ProjectConstant;
import com.cgs.gaexam.core.ServiceException;
import com.cgs.gaexam.model.Rule;
import com.cgs.gaexam.model.dto.QuestionInfo;
import com.cgs.gaexam.service.QuestionService;
import com.cgs.gaexam.utils.SpringUtil;

public class GA {

    /**
     * 变异概率
     */
    private static final double mutationRate = 0.085;
    /**
     * 精英主义
     */
    private static final boolean elitism = true;
    /**
     * 淘汰数组大小
     */
    private static final int tournamentSize = 5;

    private static QuestionService questionService = SpringUtil.getBean(QuestionService.class);

    // 进化种群
    public static Population evolvePopulation(Population pop, Rule rule) {
        Population newPopulation = new Population(pop.size());
        int elitismOffset;
        // 精英主义
        if (elitism) {
            elitismOffset = 1;
            // 保留上一代最优秀个体
            PaperIndividual fitness = pop.getFitness();
            fitness.setId(0);
            newPopulation.setPaper(0, fitness);
        }
        // 种群交叉操作，从当前的种群pop来创建下一代种群newPopulation
        for (int i = elitismOffset; i < newPopulation.size(); i++) {
            // 较优选择parent
            PaperIndividual parent1 = select(pop);
            PaperIndividual parent2 = select(pop);
            while (parent2.getId() == parent1.getId()) {
                parent2 = select(pop);
            }
            // 交叉
            PaperIndividual child = crossover(parent1, parent2, rule);
            child.setId(i);
            newPopulation.setPaper(i, child);
        }
        // 种群变异操作
        PaperIndividual tmpPaper;
        for (int i = elitismOffset; i < newPopulation.size(); i++) {
            tmpPaper = newPopulation.getPaper(i);
            mutate(tmpPaper, rule);
            // 计算知识点覆盖率与适应度
            tmpPaper.setKnowledgeCoverage(rule);
            tmpPaper.setAdaptationDegree(rule, ProjectConstant.KP_WEIGHT, ProjectConstant.DIFFICULTY_WEIGHT);
        }
        return newPopulation;
    }

    /**
     * 交叉算子
     *
     * @param parent1
     * @param parent2
     * @param rule
     * @return
     */
    public static PaperIndividual crossover(PaperIndividual parent1, PaperIndividual parent2, Rule rule) {
        PaperIndividual child = new PaperIndividual(parent1.getQuestionNumber());
        int randomPos1 = (int) (Math.random() * parent1.getQuestionNumber());
        int randomPos2 = (int) (Math.random() * parent1.getQuestionNumber());

        // parent1的startPos endPos之间的序列，会被遗传到下一代
        int startPos = randomPos1 < randomPos2 ? randomPos1 : randomPos2;
        int endPos = randomPos1 > randomPos2 ? randomPos1 : randomPos2;
        for (int i = startPos; i < endPos; i++) {
            child.saveQuestion(i, parent1.getQuestion(i));
        }

        // 继承parent2中未被child继承的question
        // 防止出现重复的元素
        for (int i = 0; i < startPos; i++) {
            inheritParentQuestion(rule, child, parent2, i);
        }
        for (int i = endPos; i < parent2.getQuestionNumber(); i++) {
            inheritParentQuestion(rule, child, parent2, i);
        }

        return child;
    }

    private static void inheritParentQuestion(Rule rule, PaperIndividual child, PaperIndividual parent, int i) {
        if (!child.containsQuestion(parent.getQuestion(i))) {
            child.saveQuestion(i, parent.getQuestion(i));
        } else {
            long typeId = parent.getQuestionType(i);
            QuestionInfo[] questionList = questionService.find(typeId, rule.getCourseId(), rule.getExpKnowledgeIds());
            int index;
            do {
                // 随机获取一道不存在原试卷中的试题
                index = (int) (Math.random() * questionList.length);
            } while (child.containsQuestion(questionList[index]));
            child.saveQuestion(i, questionList[index]);
        }
    }

    /**
     * 突变算子 每个个体的每个基因都有可能突变
     *
     * @param paper
     * @param rule
     */
    public static void mutate(PaperIndividual paper, Rule rule) {
        QuestionInfo tmpQuestion;
        QuestionInfo[] list;
        int index;
        long typeId;
        for (int i = 0; i < paper.getQuestionNumber(); i++) {
            if (Math.random() < mutationRate) {
                // 进行突变，第i道
                tmpQuestion = paper.getQuestion(i);
                typeId = tmpQuestion.getQuestionTypeId();
                // 从题库中获取和变异的题目类型、所属课程一样和包含同样知识点的题目（不包含变异题目）
                list = questionService.findExcludeQuestion(tmpQuestion.getId(), typeId, rule.getCourseId(), rule.getExpKnowledgeIds());
                //题库相应题型的数量要大于组卷规则里相应题型的数量才可进行突变，否则试卷里的题将会重复
                if (list.length > rule.getQuestionNumberByTypeId(typeId)) {
                    do {
                        // 随机获取一道不存在原试卷中的试题
                        index = (int) (Math.random() * list.length);
                    } while (paper.containsQuestion(list[index]));
                    // 设置分数
                    list[index].setScore(tmpQuestion.getScore());
                    paper.saveQuestion(i, list[index]);
                } else {
                    //throw new ServiceException("题库"+ tmpQuestion.getTypeName() +"数量不够,无法进行组卷。");
                }
            }
        }
    }

    /**
     * 选择算子
     *
     * @param population
     */
    private static PaperIndividual select(Population population) {
        Population pop = new Population(tournamentSize);
        for (int i = 0; i < tournamentSize; i++) {
            pop.setPaper(i, population.getPaper((int) (Math.random() * population.size())));
        }
        return pop.getFitness();
    }
}
