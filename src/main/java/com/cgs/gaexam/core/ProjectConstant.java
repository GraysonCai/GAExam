package com.cgs.gaexam.core;

import edu.princeton.cs.algs4.ST;

/**
 * 项目常量
 */
public final class ProjectConstant {
    public static final String BASE_PACKAGE = "com.cgs.gaexam";//项目基础包名称，根据自己公司的项目修改

    public static final String MODEL_PACKAGE = BASE_PACKAGE + ".model";//Model所在包
    public static final String MAPPER_PACKAGE = BASE_PACKAGE + ".dao";//Mapper所在包
    public static final String SERVICE_PACKAGE = BASE_PACKAGE + ".service";//Service所在包
    public static final String SERVICE_IMPL_PACKAGE = SERVICE_PACKAGE + ".impl";//ServiceImpl所在包
    public static final String CONTROLLER_PACKAGE = BASE_PACKAGE + ".web.controller";//Controller所在包

    public static final String MAPPER_INTERFACE_REFERENCE = BASE_PACKAGE + ".core.Mapper";//Mapper插件基础接口的完全限定名

    //系统角色常量
    public static final String STUDENT = "ROLE_STUDENT";
    public static final String TEACHER = "ROLE_TEACHER";
    public static final String ADMIN = "ROLE_ADMIN";

    //账号状态
    public static final Byte ENABLED = 1;
    public static final Byte DISABLED = 0;

    //性别
    public static final Byte MALE = 1;
    public static final Byte FAMALE = 0;

    //主观客观
    public static final Byte SUBJECTIVE = 1;
    public static final Byte OBJECTIVE = 0;

    //对错
    public static final Byte RIGHT = 1;
    public static final Byte WRONG = 0;

    //知识点权重
    public static final float KP_WEIGHT = 0.20F;
    //难度系数权重
    public static final float DIFFICULTY_WEIGHT = 0.80F;

    //试卷状态
    public static final Byte PAPER_UNFINISHED = 0;  //未完成
    public static final Byte PAPER_FINISHED = 1;    //完成
    public static final Byte PAPER_PUBLISHED = 2;   //发布

    //考试状态
    public static final Byte EXAM_UNPUBLISH_CODE = 0;  //未发布
    public static final Byte EXAM_PUBLISHED_CODE = 1;  //已发布

    public static final String EXAM_UNPUBLISH = "未发布";  //未发布
    public static final String EXAM_PUBLISHED = "已发布";  //已发布

//    //用户考试状态
//    public static final Byte EXAM_UNSTART_CODE = 0;  //未发布
//    public static final Byte EXAM_TESTING_CODE = 1;  //已发布
//
//    public static final String EXAM_UNPUBLISH = "未发布";  //未发布
//    public static final String EXAM_PUBLISHED = "已发布";  //已发布

    //考试结果
    public static final Byte EXAM_UNATTEND_CODE = 0; //未参加
    public static final Byte EXAM_FAILED_CODE = 1;  //不及格
    public static final Byte EXAM_PASS_CODE = 2;  //及格
    public static final Byte EXAM_RESULT_WAITING_CODE = 3;  //等待结果中

    public static final String EXAM_UNATTEND = "未参加"; //未参加
    public static final String EXAM_FAILED = "不及格";  //不及格
    public static final String EXAM_PASS = "及格";  //及格
    public static final String EXAM_RESULT_WAITING = "等待结果中";  //及格

    //考生考试状态, 0等待考试，1考试进行中，2考试中途退出, 3阅卷中, 4考试完成',
    public static final Byte STUDENT_EXAM_WAITING_CODE = 0;
    public static final Byte STUDENT_EXAM_TESTING_CODE = 1;
    public static final Byte STUDENT_EXAM_EXITED_CODE = 2;
    public static final Byte STUDENT_EXAM_READING_PAPER_CODE = 3;
    public static final Byte STUDENT_EXAM_FINISHED_CODE = 4;

    public static final String STUDENT_EXAM_WAITING = "等待考试";
    public static final String STUDENT_EXAM_TESTING = "考试进行中";
    public static final String STUDENT_EXAM_EXITED = "考试中途退出";
    public static final String STUDENT_EXAM_READING_PAPER = "阅卷中";
    public static final String STUDENT_EXAM_FINISHED = "考试完成";

    public static String getStudentExamResult(byte code) {
        if (code == EXAM_UNATTEND_CODE) {
            return EXAM_UNATTEND;
        } else if (code == EXAM_FAILED_CODE) {
            return EXAM_FAILED;
        } else if (code == EXAM_PASS_CODE) {
            return EXAM_PASS;
        } else if (code == EXAM_RESULT_WAITING_CODE) {
            return EXAM_RESULT_WAITING;
        }
        return null;
    }

    public static String getStudentExamStatus(byte code) {
        if (code == STUDENT_EXAM_WAITING_CODE) {
            return STUDENT_EXAM_WAITING;
        } else if (code == STUDENT_EXAM_TESTING_CODE) {
            return STUDENT_EXAM_TESTING;
        } else if (code == STUDENT_EXAM_EXITED_CODE) {
            return STUDENT_EXAM_EXITED;
        } else if (code == STUDENT_EXAM_FINISHED_CODE) {
            return STUDENT_EXAM_FINISHED;
        } else if (code == STUDENT_EXAM_READING_PAPER_CODE) {
            return STUDENT_EXAM_READING_PAPER;
        }
        return null;

    }

}
