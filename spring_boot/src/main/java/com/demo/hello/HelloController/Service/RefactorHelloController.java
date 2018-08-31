package com.demo.hello.HelloController.Service;

import com.ifeng.dto.User;
import com.ifeng.service.HelloService;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by i-feng on 2018/8/31.
 */

@RestController
public class RefactorHelloController implements HelloService {

    @Override
    public String hello(String s) {
        return "Hello " + s;
    }

    @Override
    public User hello(String s, Integer integer) {
        return new User(s, integer);
    }

    @Override
    public String hello(User user) {
        return "Hello " + user.getName() + ", " + user.getAge();
    }
}
