package com.sparta.spartagoods.entity.image;

import com.sparta.spartagoods.entity.item.Item;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "image")
public class ImagePhoto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageId;

    @OneToOne
    @JoinColumn(name = "item_itemId")
    private Item item;

    @Column
    private String imageUrl;
}
