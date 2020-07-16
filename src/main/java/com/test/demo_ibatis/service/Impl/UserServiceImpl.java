package com.test.demo_ibatis.service.Impl;

import com.test.demo_ibatis.Dao.UserDao;
import com.test.demo_ibatis.domain.User;
import com.test.demo_ibatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public boolean insertUser(User user) {
        return userDao.InsertUser(user);
    }

    @Override
    public List<User> selectByPassWordAndRealName(String name, String passWord) {
        return userDao.selectByPassWordAndRealName(name,passWord);
    }

    @Override
    public boolean insertBatch(List<User> list) {
        return userDao.insertBatch(list);
    }

    @Override
    public List<User> queryByDymatic(String name, List<String> list) {

        return userDao.queryByDymatic(name, list);
    }


}
