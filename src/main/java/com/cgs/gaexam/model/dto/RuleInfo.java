package com.cgs.gaexam.model.dto;

import com.cgs.gaexam.model.Rule;

public class RuleInfo extends Rule {

    private String expKnowledgesName;

    @Override
    public String toString() {
        return "RuleInfo{" +
                "expKnowledgesName='" + expKnowledgesName + '\'' +
                "} " + super.toString();
    }


    public String getExpKnowledgesName() {
        return expKnowledgesName;
    }

    public void setExpKnowledgesName(String expKnowledgesName) {
        this.expKnowledgesName = expKnowledgesName;
    }
}
