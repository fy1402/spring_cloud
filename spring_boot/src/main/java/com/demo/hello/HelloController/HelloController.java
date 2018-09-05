package com.demo.hello.HelloController;

import com.demo.hello.HelloController.Service.RefactorHelloController;
import com.demo.hello.model.Book;
import com.demo.hello.model.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Autowired
    private RefactorHelloController refactorHelloController;

    @RequestMapping("/hello")
    public String hello() {

        log.info("Hello World :");
        long start = System.currentTimeMillis();

        int sleepTime = new Random().nextInt(3000);
        log.info("sleepTime: " + sleepTime);

//        try {
//            Thread.sleep(sleepTime);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

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

//    @RequestMapping("/feign-consumer3")
//    public String helloConsumer3() {
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(refactorHelloController.hello("MIMI")).append("\n");
//        stringBuilder.append(refactorHelloController.hello("MINI", 20)).append("\n");
//        stringBuilder.append(refactorHelloController.hello(new com.ifeng.dto.User("MINI", 20))).append("\n");
//        return stringBuilder.toString();
//    }

}
