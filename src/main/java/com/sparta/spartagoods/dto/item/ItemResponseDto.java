package com.sparta.spartagoods.dto.item;

import com.sparta.spartagoods.entity.item.Item;
import com.sparta.spartagoods.entity.item.ItemCategoryEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
public class ItemResponseDto {
    private Long itemId;
    private String itemName;
    private Long price;
    private Long count;
    private String intro;

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
