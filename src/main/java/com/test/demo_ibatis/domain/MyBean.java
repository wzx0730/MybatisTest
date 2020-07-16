package com.test.demo_ibatis.domain;

import com.test.demo_ibatis.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MyBean {
    @Autowired
    private UserDao userDao;

    private User user;


        public MyBean(){
            System.out.println(user);
            System.out.println("MyBean Initializing");
        }

        public void init(){
            List<User> list = userDao.selectByPassWordAndRealName("qqqq", "aaa");
            System.out.println("Bean 初始化方法被调用");
            user=list.get(0);
        }

        public void destroy(){
            System.out.println("Bean 销毁方法被调用");
        }


}
