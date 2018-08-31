package com.example.demo;

import com.ifeng.service.*;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * Created by i-feng on 2018/8/31.
 */

@FeignClient("hello-service")
public interface RefactorHelloService extends com.ifeng.service.HelloService {



}
