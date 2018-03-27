package com.cgs.gaexam.service.impl;

import com.cgs.gaexam.core.ProjectConstant;
import com.cgs.gaexam.core.ga.GA;
import com.cgs.gaexam.core.ga.PaperIndividual;
import com.cgs.gaexam.core.ga.Population;
import com.cgs.gaexam.dao.KnowledgeMapper;
import com.cgs.gaexam.dao.PaperMapper;
import com.cgs.gaexam.dao.RuleMapper;
import com.cgs.gaexam.model.Paper;
import com.cgs.gaexam.model.Rule;
import com.cgs.gaexam.model.dto.PaperInfo;
import com.cgs.gaexam.model.dto.RuleInfo;
import com.cgs.gaexam.service.PaperService;
import com.cgs.gaexam.core.AbstractService;
import com.cgs.gaexam.service.RuleService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


/**
 * Created by CodeGenerator on 2018/01/28.
 */
@Service
@Transactional
public class PaperServiceImpl extends AbstractService<Paper> implements PaperService {
    @Autowired
    private PaperMapper gaPaperMapper;

    @Autowired
    private RuleMapper ruleMapper;

    @Autowired
    private KnowledgeMapper knowledgeMapper;

    @Override
    public List<PaperInfo> findAllPaperInfo() {
        return gaPaperMapper.findAllPaperInfo();
    }

    @Override
    public PaperInfo getPaperInfoById(Long paperId) {
        //获取试卷的详细信息
        PaperInfo paperInfo = gaPaperMapper.getPaperInfoById(paperId);
        paperInfo.setKnowledgesName(knowledgeMapper.getKnowledgesNameByIds(paperInfo.getKnowledgeIds().trim().split(",")));
        //获取组卷规则的详细信息
        Rule rule = ruleMapper.selectByPrimaryKey(paperInfo.getRuleId());
        RuleInfo ruleInfo = new RuleInfo();
        BeanUtils.copyProperties(rule, ruleInfo);
        ruleInfo.setExpKnowledgesName(knowledgeMapper.getKnowledgesNameByIds(rule.getExpKnowledgeIds().trim().split(",")));
        //设置试卷的组卷规则
        paperInfo.setRule(ruleInfo);
        return paperInfo;
    }

    @Override
    public PaperIndividual createPaper(PaperInfo paperInfo) {
        System.out.println(paperInfo);
        //TODO 初始化种群
        PaperIndividual resultPaper = null;
        int count = 0;
        int runCount = 100;
        double expand = 0.98;
        Rule rule = paperInfo.getRule();
        System.out.println("组卷规则为：" + rule);
        if (rule != null) {
            Population population = new Population();
            population.initPopulation(20, rule);
            System.out.println("初始适应度：" + population.getFitness().getAdaptationDegree());
            while (count < runCount && population.getFitness().getAdaptationDegree() < expand) {
                count++;
                population = GA.evolvePopulation(population, rule);
                if (count % 10 == 0) {
                    System.out.println("第" + count + "次迭代适应度：" + population.getFitness().getAdaptationDegree() + ",知识点覆盖率：" + population.getFitness().getKnowledgeCoverage());
                }
            }
            System.out.println("总共迭代次数：" + count);
            System.out.println(population.getFitness().getAdaptationDegree());
            resultPaper = population.getFitness();
        }
        rule.setCreateDate(new Date());
        rule.setCreateBy(1L);
        ruleMapper.insert(rule);
        System.out.println(resultPaper);
        paperInfo.setRuleId(rule.getId());
        paperInfo.setQuestionIds(resultPaper.getQuestionIds());
        paperInfo.setAdaptationDegree(resultPaper.getAdaptationDegree());
        paperInfo.setKnowledgeCoverage(resultPaper.getKnowledgeCoverage());
        paperInfo.setKnowledgeIds(resultPaper.getActknowledgeIds());
        paperInfo.setDifficulty(resultPaper.getDifficulty());
        paperInfo.setCreateDate(new Date());
        paperInfo.setCreateBy(1L); //TODO 需改为从系统获取
        paperInfo.setStatus(ProjectConstant.PAPER_UNFINISHED);
        paperInfo.setSubjective(resultPaper.isSubjective());
        gaPaperMapper.insert(paperInfo);
        resultPaper.setId(Integer.valueOf(paperInfo.getId().toString()));
        return resultPaper;
    }

    @Override
    public int updatePaperStatus(Long paperId, Byte status) {
        Paper paper = gaPaperMapper.selectByPrimaryKey(paperId);
        paper.setStatus(status);
        return gaPaperMapper.updateByPrimaryKey(paper);
    }

    @Override
    public List<Paper> findByCourseId(Long courseId) {
        Paper paper = new Paper();
        paper.setCourseId(courseId);
        return gaPaperMapper.select(paper);
    }
}
