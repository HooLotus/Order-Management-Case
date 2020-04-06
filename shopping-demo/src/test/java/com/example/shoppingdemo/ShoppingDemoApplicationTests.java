package com.example.shoppingdemo;

import com.example.shoppingdemo.entity.Shopping;
import com.example.shoppingdemo.repository.ShoppingRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShoppingDemoApplicationTests {

    @Autowired
    private ShoppingRepository shoppingRepository;

    @Test
    void findAll() {
        System.out.println(shoppingRepository.findAll());
    }

    @Test
    void contextLoads() {
    }

    @Test
    void save(){
        Shopping book = new Shopping();
        book.setName("西游记");
        book.setNum(100);
        book.setDate("1223111");
        book.setPrice(14f);
        Shopping book1 = shoppingRepository.save(book);
        System.out.println(book1);
    }

}