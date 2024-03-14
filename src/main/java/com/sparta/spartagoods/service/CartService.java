package com.sparta.spartagoods.service;

import com.sparta.spartagoods.dto.cart.TotalCartResponseDto;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CartService {

    private final ItemRepository itemRepository;
    private final CartRepository cartRepository;
    private final UserRepository userRepository;

    @Transactional
    public ResponseEntity<CartResponseDto> addCart(CartRequestDto requestDto, UserDetailsImpl user) {
        Item item = itemRepository.findById(requestDto.getItemId()).orElseThrow(() -> new IllegalArgumentException("해당 상품이 존재하지 않습니다."));
        User existingUser = userRepository.findById(user.getUser().getUserId()).get();
        Cart cart = new Cart(requestDto, existingUser, item);
        cartRepository.save(cart);

        return ResponseEntity.ok(new CartResponseDto(cart, item.getItemName()));

    }

    @Transactional(readOnly = true)
    public ResponseEntity<TotalCartResponseDto> viewCart(UserDetailsImpl userDetails) {
        Long userId = userDetails.getUser().getUserId();
        List<Cart> cartItems = cartRepository.findAllByUser_UserId(userId);

        List<CartResponseDto> cartResponseDtos = new ArrayList<>();
        Long totalPrice = 0L;

        for (Cart cartItem : cartItems) {
            Item item = itemRepository.findById(cartItem.getItem().getItemId()).get();
            totalPrice = totalPrice + item.getPrice()*cartItem.getCount();
            CartResponseDto cartResponseDto = new CartResponseDto(item, userId, cartItem);
            cartResponseDtos.add(cartResponseDto);
        }

        TotalCartResponseDto cartResponseDto = new TotalCartResponseDto(cartResponseDtos, totalPrice);
        return new ResponseEntity<>(cartResponseDto, HttpStatus.OK);

    }

    @Transactional
    public ResponseEntity<Object> editCart(Long cartID, Long count, UserDetailsImpl userDetails) {
        Cart cart = cartRepository.findById(cartID).orElseThrow(() -> new IllegalArgumentException("해당 상품은 카트에 담겨있지 않습니다."));
        if (!Objects.equals(cart.getUser().getUserId(), userDetails.getUser().getUserId())){
            throw new IllegalAccessError("해당 장바구니는 해당 회원이 생성하지 않았습니다.");
        }
        cart.setCount(count);
        cartRepository.save(cart);

        String message = String.format("카트 수량이 %d로 수정되었습니다.", count);
        return ResponseEntity.ok(message);
    }

    @Transactional
    public ResponseEntity<Object> deleteCart(Long cartId, UserDetailsImpl userDetails) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new IllegalArgumentException("해당 상품은 카트에 담겨있지 않습니다."));
        if (!Objects.equals(cart.getUser().getUserId(), userDetails.getUser().getUserId())){
            throw new IllegalAccessError("해당 장바구니는 해당 회원이 생성하지 않았습니다.");
        }
        cartRepository.delete(cart);
        return ResponseEntity.ok("해당 장바구니가 삭제 되었습니다.");
    }
}
