package com.cgs.gaexam.service;

import com.cgs.gaexam.core.Service;
import com.cgs.gaexam.core.ga.PaperIndividual;
import com.cgs.gaexam.model.Paper;
import com.cgs.gaexam.model.dto.PaperInfo;

import java.util.List;


/**
 * Created by CodeGenerator on 2018/01/28.
 */
public interface PaperService extends Service<Paper> {

    /**
     * 通过课程id查找试卷
     *
     * @return
     */
    List<Paper> findByCourseId(Long courseId);

    /**
     * 查找所有试卷信息
     *
     * @return
     */
    List<PaperInfo> findAllPaperInfo();

    /**
     * 通过id查找试卷信息
     *
     * @param paperId
     * @return
     */
    PaperInfo getPaperInfoById(Long paperId);

    /**
     * 创建试卷
     *
     * @param paperInfo
     * @return
     */
    PaperIndividual createPaper(PaperInfo paperInfo);

    /**
     * 更新试卷状态
     *
     * @param paperId
     * @param status
     * @return
     */
    int updatePaperStatus(Long paperId, Byte status);

}
