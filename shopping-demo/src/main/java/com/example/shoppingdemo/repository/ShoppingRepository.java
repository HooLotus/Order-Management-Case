package com.example.shoppingdemo.repository;

import com.example.shoppingdemo.entity.Shopping;
import org.springframework.data.jpa.repository.JpaRepository;



/**
 * @author Lenovo
 */
public interface ShoppingRepository extends JpaRepository<Shopping,Integer> {
}
