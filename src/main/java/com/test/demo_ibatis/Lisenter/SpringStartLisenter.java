package com.test.demo_ibatis.Lisenter;

import com.test.demo_ibatis.Dao.UserDao;
import com.test.demo_ibatis.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.rmi.registry.Registry;
import java.util.List;


@Component
public class SpringStartLisenter implements ApplicationRunner {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
  private UserDao userDao;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("服务器启动啦111111111111111111111111111111111");
        System.out.println(applicationContext.getBean("user",User.class));
    }
}
