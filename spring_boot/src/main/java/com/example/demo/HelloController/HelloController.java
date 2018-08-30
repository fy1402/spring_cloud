package com.example.demo.HelloController;

import com.example.demo.model.Book;
import com.example.demo.model.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

/**
 * Created by i-feng on 2018/8/23.
 */

@Log4j2
@RestController
public class HelloController {

    @Value("${book.name}")
    private String book;

    @Value(("${com.didispace.blog.int_1}"))
    private int test_01;


    @RequestMapping("/hello")
    public String hello() {

        log.info("Hello World :");
        long start = System.currentTimeMillis();

        int sleepTime = new Random().nextInt(3000);
        log.info("sleepTime: " + sleepTime);

        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        log.info("currentTime: " + (end - start));

        return "Hello World";
    }

    @RequestMapping("/book")
    public String bookName(){
        Book book1 = new Book();
        String name = book1.getBook_name();
        log.info(name);
        log.info(book);
        log.info(test_01);
        return name;
    }

    @RequestMapping("/hello1")
    public String hello(@RequestParam String name) {
        return "Hello " + name;
    }

    @RequestMapping("/hello2")
    public User hello(@RequestHeader String name, @RequestHeader Integer age) {
        return new User(name, age);
    }

    @RequestMapping("/hello3")
    public String hello(@RequestBody User user) {
        return "Hello " + user.toString();
    }



}
