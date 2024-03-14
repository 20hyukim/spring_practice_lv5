package com.sparta.spartagoods.dto.item;

import com.sparta.spartagoods.entity.item.ItemCategoryEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class ItemRequestDto {

    @Schema(description = "상품 이름", nullable = false, example = "potato")
    private String itemName;

    @Schema(description = "상품 가격", nullable = false, example = "10000")
    private Long price;

    @Schema(description = "상품 개수", nullable = false, example = "4")
    private Long count;

    @Schema(description = "상품 소개", nullable = false, example = "this is potato yummy potato")
    private String intro;

    @Schema(description = "상품 카테고리", nullable = false, example = "TACO")
    private ItemCategoryEnum category;
}
