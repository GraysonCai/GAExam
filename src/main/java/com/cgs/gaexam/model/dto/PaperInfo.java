package com.cgs.gaexam.model.dto;

import com.cgs.gaexam.model.Paper;
import com.cgs.gaexam.model.Rule;

public class PaperInfo extends Paper {
    private String courseName;
    private Byte ruleType;
    private String createUser;
    private RuleInfo rule;
    private String knowledgesName;

    @Override
    public String toString() {
        return "PaperInfo{" +
                "courseName='" + courseName + '\'' +
                ", ruleType=" + ruleType +
                ", createUser='" + createUser + '\'' +
                ", rule=" + rule +
                ", knowledgesName='" + knowledgesName + '\'' +
                "} " + super.toString();
    }

    public String getKnowledgesName() {
        return knowledgesName;
    }

    public void setKnowledgesName(String knowledgesName) {
        this.knowledgesName = knowledgesName;
    }

    public RuleInfo getRule() {
        return rule;
    }

    public void setRule(RuleInfo rule) {
        this.rule = rule;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Byte getRuleType() {
        return ruleType;
    }

    public void setRuleType(Byte ruleType) {
        this.ruleType = ruleType;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }
}
