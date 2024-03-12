package com.sparta.spartagoods.entity.cart;

import com.sparta.spartagoods.dto.cart.CartRequestDto;
import com.sparta.spartagoods.entity.item.Item;
import com.sparta.spartagoods.entity.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @ManyToOne
    @JoinColumn(name="item_itemId")
    private Item item;


    @ManyToOne
    @JoinColumn(name="user_userId")
    private User user;

    @Column
    private Long count;



    public Cart(CartRequestDto requestDto, User user, Item item) {
        this.item = item;
        this.user = user;
        this.count = requestDto.getCount();

    }
}
