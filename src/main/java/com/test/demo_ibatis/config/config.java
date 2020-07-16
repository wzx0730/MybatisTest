package com.test.demo_ibatis.config;

import com.test.demo_ibatis.Dao.UserDao;
import com.test.demo_ibatis.domain.MyBean;
import com.test.demo_ibatis.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class config {

    @Autowired
    private UserDao userDao;
    //    @Bean
    @Bean()
    public User user(){
        System.out.println(userDao);
        List<User> list = userDao.selectByPassWordAndRealName("qqqq", "aaa");
        return new User();
    }

}