package com.test.demo_ibatis.domain;

public class ResultModel {
    private String Result;
    private String info;

    public ResultModel(String result) {
        Result = result;
    }

    public ResultModel(String result, String info) {
        Result = result;
        this.info = info;
    }

    public String getResult() {
        return Result;
    }

    public void setResult(String result) {
        Result = result;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
