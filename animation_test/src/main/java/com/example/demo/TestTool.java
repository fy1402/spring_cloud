package com.example.demo;

import java.lang.reflect.Method;

/**
 * Created by i-feng on 2018/8/29.
 */
public class TestTool {

    public static void main(String[] args) {

        NoBug noBug = new NoBug();

        Class cla = noBug.getClass();

        Method[] methods = cla.getDeclaredMethods();

        StringBuilder log = new StringBuilder();
        int errornum = 0;

        for (Method method: methods) {
            if (method.isAnnotationPresent(JieCha.class)) {
                try {
                    method.setAccessible(true);
                    method.invoke(noBug, null);
                } catch (Exception e) {
                    errornum++;
                    log.append(method.getName());
                    log.append(" ");
                    log.append("has error: ");
                    log.append("\n\r caused by ");
                    log.append(e.getCause().getClass().getSimpleName());
                    log.append("\n\r");
                    log.append(e.getCause().getMessage());
                    log.append("\n\r");
                }
            }
        }

        log.append(cla.getSimpleName());
        log.append(" has  ");
        log.append(errornum);
        log.append(" error.");

        // 生成测试报告
        System.out.println(log.toString());
    }

}
