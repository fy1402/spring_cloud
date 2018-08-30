package com.example.demo;

/**
 * Created by i-feng on 2018/8/28.
 */

@TestAnnotation
public class Test1 {

    public static void main(String[] args) {

        boolean is = Test1.class.isAnnotationPresent(TestAnnotation.class);
        if (is) {
            TestAnnotation testAnnotation = Test1.class.getAnnotation(TestAnnotation.class);
            System.out.println("id: " + testAnnotation.id());
            System.out.println("msg: " + testAnnotation.msg());
        } else {
            System.out.println("null");
        }
    }

}
