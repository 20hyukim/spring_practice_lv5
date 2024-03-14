package com.sparta.spartagoods.controller;

import com.sparta.spartagoods.dto.cart.CartRequestDto;
import com.sparta.spartagoods.dto.cart.CartResponseDto;
import com.sparta.spartagoods.dto.cart.TotalCartResponseDto;
import com.sparta.spartagoods.dto.item.ItemRequestDto;
import com.sparta.spartagoods.entity.user.User;
import com.sparta.spartagoods.security.UserDetailsImpl;
import com.sparta.spartagoods.service.CartService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "장바구니 컨트롤러", description = "장바구니 등록, 조회, 편집, 삭제")
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

    @GetMapping
    @Secured("ROLE_ADMIN")
    public ResponseEntity<TotalCartResponseDto> viewCart(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return cartService.viewCart(userDetails);
    }

    @PatchMapping
    @Secured("ROLE_ADMIN")
    public ResponseEntity<Object> editCart(
            @RequestParam(name = "cartId") Long cartID,
            @RequestParam(name = "count") Long count,
            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return cartService.editCart(cartID, count, userDetails);
    }

    @DeleteMapping("/{cartId}")
    @Secured("ROLE_ADMIN")
    public ResponseEntity<Object> deleteCart(@PathVariable Long cartId, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return cartService.deleteCart(cartId, userDetails);
    }


}
