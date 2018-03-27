package com.cgs.gaexam.dao;

import com.cgs.gaexam.core.Mapper;
import com.cgs.gaexam.model.Student;
import com.cgs.gaexam.model.dto.StudentInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMapper extends Mapper<Student> {

    /**
     * 列出所有的学生信息
     *
     * @return
     */
    List<StudentInfo> findAll();

    /**
     * 通过用户id同时删除学生表和用户表的数据
     *
     * @param userId
     * @return
     */
    int deleteByUserId(@Param("userId") Long userId);

    /**
     * 通过用户id获取学生信息
     *
     * @param userId
     * @return
     */
    StudentInfo findByUserId(@Param("userId") Long userId);

    /**
     * 通过student的id更新学生信息，排除为null的情况
     *
     * @param student
     * @return
     */
    int updateStudentById(@Param("s") Student student);

    /**
     * 判断是否存在学生
     *
     * @param userId
     * @return
     */
    boolean existStudent(@Param("userId") Long userId);
}