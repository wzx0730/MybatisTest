package com.test.demo_ibatis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.test.demo_ibatis.Dao.UserDao;
import com.test.demo_ibatis.config.MySqlConfig;
import com.test.demo_ibatis.config.RabbitMQConfig;
import com.test.demo_ibatis.domain.Myclient;
import com.test.demo_ibatis.domain.User;
import com.test.demo_ibatis.domain.UserVIP;
import com.test.demo_ibatis.service.CalculateService;
import com.test.demo_ibatis.service.UserService;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.ws.Service;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class DemoIbatisApplicationTests {


    private static Logger logger = Logger.getLogger(DemoIbatisApplicationTests.class);

    @Autowired
    private MySqlConfig myAppSqlConfig;

    private SqlMapClient sqlMap = myAppSqlConfig.getSqlMapInstance();
    @Test
    void contextLoads() {

        try {

            HashMap<String, String> hash = new HashMap<>();
            hash.put("passWord","2222");
            hash.put("userName","lalal22" );
            List<User> list = sqlMap.queryForList("queryByPassWordAndRealName", hash);
            for (User o : list) {
                System.out.println(o);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        @Test
        void test01(){
            HashMap<String, Object> hash = new HashMap<>();

            User user1 = new User();
            User user2 = new User();
            user1.setId(1);
            user2.setId(2);

            ArrayList<User> users = new ArrayList<>();
            users.add(user1);
            users.add(user2);
            hash.put("users",users);
            hash.put("userName","双11" );
            try {
                int count = sqlMap.update("updateByPassWordAndRealName", hash);
                System.out.println(count);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Test
        void test2(){
            User user1 = new User();
            User user2 = new User();
            user1.setRealName("lalal");
            user1.setPassWord("papapa");
            user1.setUserName("uuuuuu");
            user2.setRealName("lalal22");
            user2.setPassWord("2222");
            user2.setUserName("uuuuuu222");
            ArrayList<User> users = new ArrayList<>();
            users.add(user1);
            users.add(user2);
            try {
                int insertBatch = sqlMap.update("insertBatch", users);
                System.out.println(insertBatch);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        @Test
        void test3(){
            HashMap<String, Object> hash = new HashMap<>();

            User user1 = new User();
            User user2 = new User();
            user1.setRealName("3");
            user2.setRealName("4");

            ArrayList<User> users = new ArrayList<>();
            users.add(user1);
            users.add(user2);
            hash.put("users",users);
            hash.put("userName","ggg");

            logger.info(hash);
            try {
                int count = sqlMap.delete("deleteByUserNameAndRealName", hash);
                System.out.println(count);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Test
        void test04(){
            ArrayList<User> list = new ArrayList<>();
            User user = new User();
            User user1 = new User();
            User user2 = new User();
            User user3 = new User();
            user.setId(11);
            list.add(user);
            user1.setId(5);
            list.add(user1);
            user2.setId(2);
            list.add(user2);
            user3.setId(1);
            list.add(user3);
            List<Integer> collect = list.stream().filter(s -> s.getId() > 4).map(s -> s.getId()).sorted().collect(Collectors.toList());
            System.out.println(collect);

        }

        @Test
        void test5() {
            try {
                String name="aaa";
                assert(name==null):"变量name为空null";
                System.out.println(name);
            } catch (RuntimeException e) {
                System.out.println("又报错了");
                throw new RuntimeException("出错啦");
            }
        }
        @Test
        void Test6(){
            UserVIP userVIP = new UserVIP();
            userVIP.setId(1);
            userVIP.setLevel("1");
            userVIP.setUserName("wzx");
            userVIP.setPassWord("111");
            userVIP.setRealName("lll");
            User user = new User();

            BeanUtils.copyProperties(userVIP, user);
            System.out.println(user);


        }


        @Test
        void Test7(){
            String str="{'key':'2','list':[{'userName': 'wzx', 'passWord': '3322', 'realName':'2333', 'level':'1'},{'userName': '222', 'passWord': '222', 'realName':'333', 'level':'2'}]}";
            JSONObject jsonObject = JSON.parseObject(str);
            Object list = jsonObject.get("list");
            List<JSONObject> list1 = (List<JSONObject>) list;
            for (JSONObject object : list1) {
                User user = JSONObject.toJavaObject(object, User.class);
                System.out.println(user);
            }



        }

        @Autowired
        CalculateService calculateService;

        @Test
        void Test8(){
            System.out.println(calculateService.getResult("ADD", 5, 6));
            System.out.println(calculateService.getResult("SUB", 5, 6));

        }

        @Autowired
        private UserDao userDao;

        @Test
    void test09(){
            ArrayList<String> strings = new ArrayList<>();
            strings.add("1");
            strings.add("31");
            strings.add("39");
            System.out.println("输入结果");
            System.out.println(userDao.queryByDymatic(null, null));

        }

        @Autowired
        private AmqpAdmin amqpAdmin;

        @Autowired
        private RabbitTemplate rabbitTemplate;


        @Test
        void TestMq(){
            rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME,
                    RabbitMQConfig.ROUTING_KEY, "hello world");


        }

    @Test
    void TestMqREV(){
        Message receive = rabbitTemplate.receive("spring-boot-queue");


        if (receive!=null){
            System.out.println(receive.toString());
        }

    }

}
