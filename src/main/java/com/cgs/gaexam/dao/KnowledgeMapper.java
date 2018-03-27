package com.cgs.gaexam.dao;

import com.cgs.gaexam.core.Mapper;
import com.cgs.gaexam.model.Knowledge;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface KnowledgeMapper extends Mapper<Knowledge> {

    /**
     * 通过id获取多个知识点字符串，以逗号分隔
     *
     * @param ids
     * @return
     */
    String getKnowledgesNameByIds(@Param("ids") String[] ids);
}