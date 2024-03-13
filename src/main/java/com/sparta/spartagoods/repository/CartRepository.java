package com.sparta.spartagoods.repository;

import com.sparta.spartagoods.entity.cart.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {

    List<Cart> findAllByUser_UserId(Long userId);
}
