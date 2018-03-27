package com.cgs.gaexam.core.ga;

import com.cgs.gaexam.core.ProjectConstant;
import com.cgs.gaexam.model.Rule;

/**
 * 种群，即多套试卷
 */
public class Population {

    /**
     * 试卷个体集合
     */
    private PaperIndividual[] papers;

    /**
     * 初始种群
     *
     * @param populationSize 种群规模
     * @param rule           规则bean
     */
    public void initPopulation(int populationSize, Rule rule) {
        papers = new PaperIndividual[populationSize];
        PaperIndividual paper;

        for (int i = 0; i < populationSize; i++) {
            paper = new PaperIndividual();
            paper.setId(i + 1);
            while (!paper.getTotalScore().equals(rule.getTotalScore())) {
                paper.clearQuestionList();
                // 生成试题
                paper.generateQuestion(rule);
            }
            // 计算试卷知识点覆盖率
            paper.setKnowledgeCoverage(rule);
            // 计算试卷适应度
            paper.setAdaptationDegree(rule, ProjectConstant.KP_WEIGHT, ProjectConstant.DIFFICULTY_WEIGHT);
            papers[i] = paper;
        }
    }

    /**
     * 获取种群中最优秀个体
     *
     * @return
     */
    public PaperIndividual getFitness() {
        PaperIndividual paper = papers[0];
        for (int i = 1; i < papers.length; i++) {
            if (paper.getAdaptationDegree() < papers[i].getAdaptationDegree()) {
                paper = papers[i];
            }
        }
        return paper;
    }

    public Population(int populationSize) {
        papers = new PaperIndividual[populationSize];
    }

    public Population() {
    }

    /**
     * 获取种群中某个个体
     *
     * @param index
     * @return
     */
    public PaperIndividual getPaper(int index) {
        return papers[index];
    }

    /**
     * 设置种群中某个个体
     *
     * @param index
     * @param paper
     */
    public void setPaper(int index, PaperIndividual paper) {
        papers[index] = paper;
    }

    /**
     * 返回种群规模
     *
     * @return
     */
    public int size() {
        return papers.length;
    }
}
