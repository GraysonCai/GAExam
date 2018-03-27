//package com.cgs.gaexam.core.ga1.ga;
//
///**
// * ������
// *
// * @author lixiaolin
// * @createDate 2016-06-22 20:23
// */
//public class MainTest {
//    public static void main(String[] args) {
//        Paper resultPaper = null;
//        // ����������
//        int count = 0;
//        int runCount = 100;
//        // ��Ӧ������ֵ
//        double expand = 0.98;
//        // ���Լ���ʼ��������rule
//        if (rule != null) {
//            // ��ʼ����Ⱥ
//            Population population = new Population(20, true, rule);
//            System.out.println("������Ӧ��  " + population.getFitness().getAdaptationDegree());
//            while (count < runCount && population.getFitness().getAdaptationDegree() < expand) {
//                count++;
//                population = GA.evolvePopulation(population, rule);
//                System.out.println("�� " + count + " �ν�������Ӧ��Ϊ�� " + population.getFitness().getAdaptationDegree());
//            }
//            System.out.println("���������� " + count);
//            System.out.println(population.getFitness().getAdaptationDegree());
//            resultPaper = population.getFitness();
//        }
//        System.out.println(resultPaper);
//    }
//}
