package com.sparta.spartagoods.controller;

import com.sparta.spartagoods.dto.item.ItemRequestDto;
import com.sparta.spartagoods.dto.item.ItemResponseDto;
import com.sparta.spartagoods.security.UserDetailsImpl;
import com.sparta.spartagoods.service.ItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/")
    @Secured("ROLE_ADMIN")
    public ResponseEntity<ItemResponseDto> createItem(@Valid @RequestBody ItemRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return itemService.createItem(requestDto);
    }

}