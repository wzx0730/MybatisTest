package com.test.demo_ibatis.singleton;

public class Single {
    public static final Single single = new Single();

    private Single() {
        System.out.println("对象被创建");
    }


}
