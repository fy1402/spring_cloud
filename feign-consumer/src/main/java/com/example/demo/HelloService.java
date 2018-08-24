package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by i-feng on 2018/8/24.
 */

@FeignClient("hello-service")
public interface HelloService {

    @RequestMapping("/hello")
    public String hello();
}
