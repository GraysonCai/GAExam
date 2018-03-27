package com.cgs.gaexam.model.dto;

import com.cgs.gaexam.model.Academy;

public class AcademyInfo extends Academy {
    private String createUser;

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    @Override
    public String toString() {
        return "AcademyInfo{" +
                "createUser='" + createUser + '\'' +
                "} " + super.toString();
    }
}
