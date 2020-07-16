package com.test.demo_ibatis.domain;

import lombok.Data;

import java.util.List;

@Data
public class TestVO {
    private String count;
    private Integer version;
    private List<User> userList;

}
