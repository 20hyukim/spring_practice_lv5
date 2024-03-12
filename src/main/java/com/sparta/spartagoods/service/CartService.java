package com.sparta.spartagoods.service;

import com.sparta.spartagoods.dto.cart.CartRequestDto;
import com.sparta.spartagoods.dto.cart.CartResponseDto;
import com.sparta.spartagoods.entity.cart.Cart;
import com.sparta.spartagoods.entity.item.Item;
import com.sparta.spartagoods.entity.user.User;
import com.sparta.spartagoods.repository.CartRepository;
import com.sparta.spartagoods.repository.ItemRepository;
import com.sparta.spartagoods.repository.UserRepository;
import com.sparta.spartagoods.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final ItemRepository itemRepository;
    private final CartRepository cartRepository;
    private final UserRepository userRepository;

    public ResponseEntity<CartResponseDto> addCart(CartRequestDto requestDto, UserDetailsImpl user) {
        Item item = itemRepository.findById(requestDto.getItemId()).orElseThrow(() -> new IllegalArgumentException("해당 상품이 존재하지 않습니다."));
        User existingUser = userRepository.findById(user.getUser().getUserId()).get();
        Cart cart = new Cart(requestDto, existingUser, item);
        cartRepository.save(cart);

        return ResponseEntity.ok(new CartResponseDto(cart, item.getItemName()));

    }

/*    public ResponseEntity<List<CartResponseDto>> viewCart(UserDetailsImpl userDetails) {
        Long userId = userDetails.getUser().getUserId();
        cartRepository.findAllByUser_UserID(userId);

    }*/
}
