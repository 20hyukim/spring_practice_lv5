package com.sparta.spartagoods.entity.item;

import com.sparta.spartagoods.dto.item.ItemRequestDto;
import com.sparta.spartagoods.entity.cart.Cart;
import com.sparta.spartagoods.entity.image.ImagePhoto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "item")
    private List<Cart> itemCart = new ArrayList<>();

    @OneToOne(mappedBy = "item")
    private ImagePhoto imagePhoto;

    public Item(ItemRequestDto requestDto) {
        this.itemName = requestDto.getItemName();
        this.price = requestDto.getPrice();
        this.count = requestDto.getCount();
        this.intro = requestDto.getIntro();
        this.category = requestDto.getCategory();
    }
}
