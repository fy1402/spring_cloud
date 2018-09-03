package com.example.demo;

import com.ifeng.dto.*;
import com.ifeng.dto.User;
import com.ifeng.service.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

/**
 * Created by i-feng on 2018/8/31.
 */

@Service
@FeignClient("hello-service")
public interface RefactorHelloService extends com.ifeng.service.HelloService {

}
