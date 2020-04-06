//package com.example.shoppingdemo;
//
//import com.example.shoppingdemo.entity.Shopping;
//import com.example.shoppingdemo.service.ShoppingService;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//
//@SpringBootTest
//@Slf4j
//public class ShoppingTest {
//    @Autowired
//    ShoppingService shoppingService;
//
//    @Test
//    public void testFindAll(){
//        List<Shopping> all = shoppingService.findAll();
//        for (Shopping shopping : all) {
//            log.info(shopping.toString());
//        }
//    }
//    @Test
//    public void testDelete(){
//        int delete = shoppingService.delete(3);
//        log.info(delete+"");
//    }
//
//    @Test
//    public void testInsert(){
//        Shopping shopping = Shopping.builder().name("Oppo").time("2020-3-20 11:23:40").price(800).num(10).build();
//        int insert = shoppingService.insert(shopping);
//        log.info(insert+"");
//    }
//
////    @Test
////    public void testUpdate(){
////        Orders orders = Orders.builder().id(1).num(10).build();
////        int update = ordersService.update(orders);
////        log.info(update+"");
////    }
//}