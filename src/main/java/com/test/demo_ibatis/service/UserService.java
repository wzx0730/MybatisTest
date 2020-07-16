package com.test.demo_ibatis.service;


import com.test.demo_ibatis.domain.User;
import java.util.List;


public interface UserService {
    boolean insertUser(User user);

    List<User> selectByPassWordAndRealName(String name, String passWord);

    boolean insertBatch(List<User> list);

    List<User> queryByDymatic(String name,List<String> list);
}
