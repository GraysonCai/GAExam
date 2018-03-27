package com.cgs.gaexam.service.impl;

import com.cgs.gaexam.dao.KnowledgeMapper;
import com.cgs.gaexam.model.Knowledge;
import com.cgs.gaexam.service.KnowledgeService;
import com.cgs.gaexam.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by CodeGenerator on 2018/01/16.
 */
@Service
@Transactional
public class KnowledgeServiceImpl extends AbstractService<Knowledge> implements KnowledgeService {
    @Autowired
    private KnowledgeMapper gaKnowledgeMapper;

    @Override
    public List<Knowledge> findByCourseId(Long courseId) {
        return gaKnowledgeMapper.select(new Knowledge(courseId));
    }

}
