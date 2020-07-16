package com.test.demo_ibatis.Enum;

public enum  MethodEnum {

    ADD("加法","ADD"),
    SUB("减法","SUB"),
    ;


    private String name;
    private String code;

    MethodEnum(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static MethodEnum getEnumByString(String str){
        for (MethodEnum methodEnum : MethodEnum.values()) {
            if (methodEnum.code.equals(str)){
                return methodEnum;
            }
        }
        return null;
    }
}
