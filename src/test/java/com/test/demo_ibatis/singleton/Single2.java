package com.test.demo_ibatis.singleton;

public class Single2 {
    private static Single2 single2 = new Single2();

    private Single2() {
    }
    public static Single2 getSingle2(){
        return single2;
    }
}
