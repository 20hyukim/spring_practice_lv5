package com.sparta.spartagoods.entity.item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {
    private String itemName;
    private Long price;
    private Long count;
    private String intro;
    private com.sparta.spartagoods.entity.item.ItemCategoryEnum category;
}
