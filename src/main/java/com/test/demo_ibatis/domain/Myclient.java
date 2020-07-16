package com.test.demo_ibatis.domain;


import lombok.Data;

@Data
public class  Myclient {
    private  User user;

    public Myclient(User user) {
        this.user = user;
    }
}
