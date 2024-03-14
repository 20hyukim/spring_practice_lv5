package com.sparta.spartagoods.dto.item;

import com.sparta.spartagoods.entity.item.Item;
import com.sparta.spartagoods.entity.item.ItemCategoryEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
public class ItemResponseDto {

    @Schema(description = "상품 번호", nullable = false, example = "1")
    private Long itemId;

    @Schema(description = "상품 이름", nullable = false, example = "potato")
    private String itemName;

    @Schema(description = "상품 가격", nullable = false, example = "10002")
    private Long price;

    @Schema(description = "상품 개수", nullable = false, example = "4")
    private Long count;

    @Schema(description = "상품 소개", nullable = false, example = "hi this is potato im potato")
    private String intro;

    @Schema(description = "상품 카테고리", nullable = false, example = "TACO")
    private ItemCategoryEnum category;

    public ItemResponseDto(Item item) {
        this.itemId = item.getItemId();
        this.itemName = item.getItemName();
        this.price = item.getPrice();
        this.count = item.getCount();
        this.intro = item.getIntro();
        this.category = item.getCategory();

    }
}
