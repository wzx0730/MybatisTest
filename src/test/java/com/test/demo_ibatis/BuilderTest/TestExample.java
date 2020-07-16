package com.test.demo_ibatis.BuilderTest;

import com.test.demo_ibatis.singleton.Single;
import com.test.demo_ibatis.singleton.Single2;
import org.junit.jupiter.api.Test;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static com.test.demo_ibatis.BuilderTest.NyPizza.Size.BIG;
import static com.test.demo_ibatis.BuilderTest.Pizza.Topping.ONION;
import static com.test.demo_ibatis.BuilderTest.Pizza.Topping.SAUAGE;

public class TestExample {

    @Test
    void test1(){
        Pizza myPizza = new NyPizza.Builder(BIG).addTopping(SAUAGE).addTopping(ONION).build();
        System.out.println(myPizza.toppings);

        Car car = new Car.CarBuilder().brand(Car.Brand.FARRAY).colors(Car.Colors.YELLOW).length(8).build();
        System.out.println(car);
    }

    @Test
    void test2(){
        Class<?> aClass = Single.class;
        try {
            Constructor<?> declaredConstructor = aClass.getDeclaredConstructor();
            declaredConstructor.setAccessible(true);
            System.out.println(declaredConstructor.newInstance()==declaredConstructor.newInstance());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        Single2 single1 = Single2.getSingle2();
        Single2 single2 = Single2.getSingle2();

    }
}
