package com.sparta.spartagoods.dto.cart;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartRequestDto {

    private Long itemId;
    private Long count;
}
