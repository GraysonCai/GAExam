package com.cgs.gaexam.service;

import com.cgs.gaexam.model.Knowledge;
import com.cgs.gaexam.core.Service;

import java.util.List;


/**
 * Created by CodeGenerator on 2018/01/16.
 */
public interface KnowledgeService extends Service<Knowledge> {

    /**
     * 通过课程查找知识点列表
     *
     * @param courseId
     * @return
     */
    List<Knowledge> findByCourseId(Long courseId);
}
