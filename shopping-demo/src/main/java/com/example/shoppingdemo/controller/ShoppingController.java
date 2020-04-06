package com.example.shoppingdemo.controller;


import com.example.shoppingdemo.entity.Shopping;
import com.example.shoppingdemo.repository.ShoppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;


/**
 * @author Lenovo
 */
@RestController
@RequestMapping("/shopping")
public class ShoppingController {

    @Autowired
    private ShoppingRepository shoppingRepository;

    //查询所有的订单
    @GetMapping("/findAll/{page}/{size}")
    public Page<Shopping> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest request = PageRequest.of(page,size);
        return shoppingRepository.findAll(request);
    }


    //加入订单的接口
    @PostMapping("/save")
    public String save(@RequestBody Shopping shopping){
        Shopping result = shoppingRepository.save(shopping);
        if (result != null){
            return "success";
        }else {
            return "error";
        }
    }

    @PutMapping("/update")
    public String update(@RequestBody Shopping shopping){
        Shopping result = shoppingRepository.save(shopping);
        if (result != null){
            return "success";
        }else {
            return "error";
        }
    }
    //删除
    @DeleteMapping("/deleteById/{id}")
    public void delete(@PathVariable("id") Integer id){
        shoppingRepository.deleteById(id--);

    }
}
