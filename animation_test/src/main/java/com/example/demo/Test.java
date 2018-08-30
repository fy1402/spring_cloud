package com.example.demo;

import javafx.animation.Animation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by i-feng on 2018/8/28.
 */


@TestAnnotation(msg = "Hello")
public class Test {

    @Check("hi")
    int a;

    @Perform
    public void testMethod(){}


    @SuppressWarnings("deprecation")
    public void sya() {
        Hero hero = new Hero();
        hero.say();
        hero.speak();
    }


    public static void main(String[] args) {

        try {
            Field a = Test.class.getDeclaredField("a");
            a.setAccessible(true);

            //获取一个成员变量上的注解
            Check check = a.getAnnotation(Check.class);

            if (check != null) {
                System.out.println("check value:"+check.value());
            }

            Method testMethod = Test.class.getDeclaredMethod("testMethod");

            if (testMethod != null) {
                // 获取方法中的注解
                Annotation[] animations = testMethod.getAnnotations();
                for (Annotation animation : animations) {
                    System.out.println("method testMethod annotation:"+animation.annotationType().getSimpleName());
                }
            }


        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}
