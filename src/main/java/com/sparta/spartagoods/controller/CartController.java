package com.sparta.spartagoods.controller;

import com.sparta.spartagoods.dto.cart.CartRequestDto;
import com.sparta.spartagoods.dto.cart.CartResponseDto;
import com.sparta.spartagoods.dto.item.ItemRequestDto;
import com.sparta.spartagoods.security.UserDetailsImpl;
import com.sparta.spartagoods.service.CartService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    @PostMapping
    @Secured("ROLE_ADMIN")
    public ResponseEntity<CartResponseDto> addCart(@Valid @RequestBody CartRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
        return cartService.addCart(requestDto, userDetails);
    }



}
