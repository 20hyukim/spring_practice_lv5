package com.sparta.spartagoods.entity.item;

import com.sparta.spartagoods.dto.item.ItemRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    @Column(nullable = false)
    private String itemName;

    @Column(nullable = false)
    private Long price;

    @Column(nullable = false)
    private Long count;

    @Column(nullable = false)
    private String intro;

    @Column(nullable = false)
    private ItemCategoryEnum category;

    public Item(ItemRequestDto requestDto) {
        this.itemName = requestDto.getItemName();
        this.price = requestDto.getPrice();
        this.count = requestDto.getCount();
        this.intro = requestDto.getIntro();
        this.category = requestDto.getCategory();
    }
}
