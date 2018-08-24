package com.example.demo;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by i-feng on 2018/8/24.
 */

@Log4j2
@RestController
public class ConsumerController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/ribbon-consumer")
    public String helloConsumer() {
//        return restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
        return helloService.helloService();
    }

}
