package com.sparta.spartagoods.dto.cart;

import com.sparta.spartagoods.dto.cart.CartResponseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TotalCartResponseDto {
    private List<CartResponseDto> cartItems;
    private Long totalPrice;
    public TotalCartResponseDto(List<CartResponseDto> cartResponseDtos, Long totalPrice) {
        this.cartItems = cartResponseDtos;
        this.totalPrice = totalPrice;
    }
}
