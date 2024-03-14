package com.sparta.spartagoods.dto.cart;

import com.sparta.spartagoods.dto.cart.CartResponseDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TotalCartResponseDto {
    @Schema(description = "카트 목록", nullable = false, example = "목록들 출력")
    private List<CartResponseDto> cartItems;

    @Schema(description = "총 가격", nullable = false, example = "2400000")
    private Long totalPrice;
    public TotalCartResponseDto(List<CartResponseDto> cartResponseDtos, Long totalPrice) {
        this.cartItems = cartResponseDtos;
        this.totalPrice = totalPrice;
    }
}
