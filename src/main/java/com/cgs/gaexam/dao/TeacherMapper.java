package com.cgs.gaexam.dao;

import com.cgs.gaexam.core.Mapper;
import com.cgs.gaexam.model.Teacher;
import com.cgs.gaexam.model.dto.TeacherInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherMapper extends Mapper<Teacher> {

    /**
     * 列出所有的教师信息
     *
     * @return
     */
    List<TeacherInfo> findAll();

    /**
     * 通过用户id同时删除教师表和用户表的数据
     *
     * @param userId
     * @return
     */
    int deleteByUserId(@Param("userId") Long userId);

    /**
     * 通过用户id获取教师信息
     *
     * @param userId
     * @return
     */
    TeacherInfo findByUserId(@Param("userId") Long userId);

    /**
     * 通过teacher的id更新教师信息，排除为null的情况
     *
     * @param teacher
     * @return
     */
    int updateTeacherById(@Param("t") Teacher teacher);

    /**
     * 判断是否存在教师
     *
     * @param userId
     * @return
     */
    boolean existTeacher(@Param("userId") Long userId);
}