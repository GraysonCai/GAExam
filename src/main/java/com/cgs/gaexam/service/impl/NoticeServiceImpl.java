package com.cgs.gaexam.service.impl;

import com.cgs.gaexam.dao.NoticeMapper;
import com.cgs.gaexam.model.Notice;
import com.cgs.gaexam.service.NoticeService;
import com.cgs.gaexam.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.*;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/04/02.
 */
@Service
@Transactional
public class NoticeServiceImpl extends AbstractService<Notice> implements NoticeService {
    @Autowired
    private NoticeMapper gaNoticeMapper;

}
