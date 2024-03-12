package com.sparta.spartagoods.dto.cart;

import com.sparta.spartagoods.entity.cart.Cart;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartResponseDto {
    private Long userId;
    private Long itemId;
    private String itemName;
    private Long count;

    public CartResponseDto(Cart cart, String itemName) {
        this.userId = cart.getUser().getUserId();
        this.itemId = cart.getItem().getItemId();
        this.itemName = itemName;
        this.count = cart.getCount();
    }
}
