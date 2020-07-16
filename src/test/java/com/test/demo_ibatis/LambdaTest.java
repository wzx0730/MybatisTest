package com.test.demo_ibatis;
import com.test.demo_ibatis.domain.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaTest {
    @Test
    void test(){
        ArrayList<User> users1 = new ArrayList<>();
        ArrayList<User> users2 = new ArrayList<>();
        User user1 = new User();
        user1.setId(1);
        User user2 = new User();
        user2.setId(2);
        User user3 = new User();
        user3.setId(3);
        User user4 = new User();
        user4.setId(4);
        users1.add(user1);
        users1.add(user2);
        users1.add(user3);
        users2.add(user2);
        users2.add(user3);
        users2.add(user4);

        List<Integer> ids1 = users1.stream().map(User::getId).collect(Collectors.toList());
        List<Integer> ids2 = users2.stream().map(User::getId).collect(Collectors.toList());
        System.out.println(ids1);
        System.out.println(ids2);
        Integer integer = ids1.stream().max(Integer::compareTo).get();
        System.out.println(integer);

        ids1.stream().filter(s->!ids2.contains(s)).map(i -> i+10).forEach(System.out::println);
        System.out.println();

    }
}
