package com.sparta.spartagoods.repository;

import com.sparta.spartagoods.entity.cart.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
