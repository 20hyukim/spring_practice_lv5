package com.sparta.spartagoods.entity.item;

import com.sparta.spartagoods.entity.user.UserRoleEnum;

public enum ItemCategoryEnum {

    ICECREAM(ItemCategoryEnum.Category.ICECREAM),
    SNACK(ItemCategoryEnum.Category.SNACK),
    VEGETABLE(ItemCategoryEnum.Category.VEGETABLE),
    RAMEN(ItemCategoryEnum.Category.RAMEN),
    TACO(ItemCategoryEnum.Category.TACO),
    MEAT(ItemCategoryEnum.Category.MEAT);

    private final String category;

    ItemCategoryEnum(String category) { this.category = category; }

    public String getCategory() { return this.category; }

    public static class Category {
        public static final String ICECREAM = "CATEGORY_ICECREAM";
        public static final String SNACK = "CATEGORY_SNACK";
        public static final String VEGETABLE = "CATEGORY_VEGETABLE";
        public static final String RAMEN = "CATEGORY_RAMEN";
        public static final String TACO = "CATEGORY_TACO";
        public static final String MEAT = "CATEGORY_MEAT";

    }

}
