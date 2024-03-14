package com.sparta.spartagoods.dto.cart;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartRequestDto {
    @Schema(description = "상품 아이디", nullable = false, example = "1")
    private Long itemId;

    @Schema(description = "상품 개수", nullable = false, example = "3")
    private Long count;
}
