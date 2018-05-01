package com.cgs.gaexam.dao;

import com.cgs.gaexam.core.Mapper;
import com.cgs.gaexam.model.Paper;
import com.cgs.gaexam.model.Question;
import com.cgs.gaexam.model.dto.PaperInfo;
import com.cgs.gaexam.model.dto.QuestionInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaperMapper extends Mapper<Paper> {

    List<PaperInfo> findAllPaperInfo();

    PaperInfo getPaperInfoById(@Param("id") Long paperId);

    List<Question> findQuestionAnswer(@Param("ids") String[] paperIds);
}