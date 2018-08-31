package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by i-feng on 2018/8/24.
 */

@RestController
public class ConsumerController {

    @Autowired
    private HelloService helloService;

    @Autowired
    private RefactorHelloService refactorHelloService;

    @RequestMapping("/feign-consumer")
    public String helloConsumer() {
        return helloService.hello();
    }

    @RequestMapping("/feign-consumer2")
    public String helloConsumer2() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(helloService.hello()).append("\n");
        stringBuilder.append(helloService.hello("DIDI")).append("\n");
        stringBuilder.append(helloService.hello("DIDI", 100)).append("\n");
        stringBuilder.append(helloService.hello(new User("DIDI", 100))).append("\n");
        return stringBuilder.toString();
    }

    @RequestMapping("/feign-consumer3")
    public String helloConsumer3() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(refactorHelloService.hello("MIMI")).append("\n");
        stringBuilder.append(refactorHelloService.hello("MINI", 20)).append("\n");
        stringBuilder.append(refactorHelloService.hello(new com.ifeng.dto.User("MINI", 20))).append("\n");
        return stringBuilder.toString();
    }
}
