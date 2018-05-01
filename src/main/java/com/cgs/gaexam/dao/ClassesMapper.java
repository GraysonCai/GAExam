package com.cgs.gaexam.dao;

import com.cgs.gaexam.core.Mapper;
import com.cgs.gaexam.model.Classes;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassesMapper extends Mapper<Classes> {

    /**
     * 查找用户所在的班级信息
     *
     * @param userId
     * @return
     */
    Classes getUserClass(@Param("userId") long userId);
}