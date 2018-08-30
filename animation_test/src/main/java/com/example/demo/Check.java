package com.example.demo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by i-feng on 2018/8/28.
 */

//@Target(ElementType.TYPE)
//@Retention(RetentionPolicy.RUNTIME)
public @interface Check {

    String value();

}
