package com.sparta.spartagoods.dto.cart;

import com.sparta.spartagoods.entity.cart.Cart;
import com.sparta.spartagoods.entity.item.Item;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartResponseDto {

    @Schema(description = "카트 아이디", nullable = false, example = "1")
    private Long userId;

    @Schema(description = "상품 아이디", nullable = false, example = "3")
    private Long itemId;

    @Schema(description = "상품 이름", nullable = false, example = "potato")
    private String itemName;

    @Schema(description = "상품 개수", nullable = false, example = "3")
    private Long count;

    public CartResponseDto(Cart cart, String itemName) {
        this.userId = cart.getUser().getUserId();
        this.itemId = cart.getItem().getItemId();
        this.itemName = itemName;
        this.count = cart.getCount();
    }


    public CartResponseDto(Item item, Long userId, Cart cartItem) {
        this.userId = userId;
        this.itemId = item.getItemId();
        this.itemName = item.getItemName();
        this.count = cartItem.getCount();
    }

}
