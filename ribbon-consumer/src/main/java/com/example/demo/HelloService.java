package com.example.demo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by i-feng on 2018/8/24.
 */

@Service
public class HelloService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallBack")
    public String helloService(){
        return restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
    }
//
//    @HystrixCommand(fallbackMethod = "helloFallBack")
//    public User UserService() {
//        return restTemplate.getForObject("http://HELLO-SERVICE/hello", User.class);
//    }


    public String helloFallBack() {
        return "error";
    }

}
