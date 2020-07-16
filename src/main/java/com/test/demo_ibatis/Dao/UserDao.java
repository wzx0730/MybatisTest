package com.test.demo_ibatis.Dao;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.test.demo_ibatis.config.MySqlConfig;
import com.test.demo_ibatis.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

@Repository
public class UserDao {

    @Autowired
    private MySqlConfig myAppSqlConfig;

    private SqlMapClient sqlMap = myAppSqlConfig.getSqlMapInstance();

    public boolean InsertUser(User user) {
        try {
            System.out.println(user);
            sqlMap.insert("insertUser", user);
            return  true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public List<User> selectByPassWordAndRealName(String name,String passWord) {

        try {

            HashMap<String, Object> map = new HashMap<>();
            map.put("passWord", passWord);
            map.put("userName", name);

            return sqlMap.queryForList("queryByPassWordAndRealName", map);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean insertBatch(List<User> list){
        try {
            return sqlMap.update("insertBatch", list)>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<User> queryByDymatic(String name,List<String> list){
        HashMap<String, Object> map = new HashMap<>();
        map.put("list", list);
        map.put("userName", name);
        try {
            return sqlMap.queryForList("queryByDymatic",map);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
