package com.cgs.gaexam.core.ga;

import com.cgs.gaexam.Tester;
import com.cgs.gaexam.model.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class GATest extends Tester {

    @Test
    public void evolvePopulation() {
        PaperIndividual resultPaper = null;
        int count = 0;
        int runCount = 100;
        double expand = 0.98;
        Rule rule = new Rule();
        if (rule != null) {
            Population population = new Population();
            population.initPopulation(20, rule);
            System.out.println("初始适应度：" + population.getFitness().getAdaptationDegree());
            while (count < runCount && population.getFitness().getAdaptationDegree() < expand) {
                count++;
                population = GA.evolvePopulation(population, rule);
                System.out.println("第" + count + "次迭代适应度：" + population.getFitness().getAdaptationDegree());
            }
            System.out.println("总共迭代次数：" + count);
            System.out.println(population.getFitness().getAdaptationDegree());
            resultPaper = population.getFitness();
        }
        System.out.println(resultPaper);
    }
}