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

    @RequestMapping("/feign-consumer")
    public String helloConsumer() {
        return helloService.hello();
    }

}
