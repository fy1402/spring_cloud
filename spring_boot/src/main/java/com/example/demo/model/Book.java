package com.example.demo.model;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by i-feng on 2018/8/23.
 */

@Component
//@Data
public class Book {

    @Value("${book.name}")
    private String book_name;


    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }
}
