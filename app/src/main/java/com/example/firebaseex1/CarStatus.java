package com.example.firebaseex1;

public class CarStatus {
    public String carlocation; //차위치는 string으로 넣고
    public Boolean carstatus; //주차 상태는 0 과 1로 표현

    public String getCarlocation() {
        return carlocation;
    }

    public void setCarlocation(String carlocation) {
        this.carlocation = carlocation;
    }

    public Boolean getCarstatus() {
        return carstatus;
    }

    public void setCarstatus(Boolean carstatus) {
        this.carstatus = carstatus;
    }



}

