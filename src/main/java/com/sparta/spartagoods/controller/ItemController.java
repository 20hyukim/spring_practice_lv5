package com.sparta.spartagoods.controller;

import com.sparta.spartagoods.dto.item.ItemRequestDto;
import com.sparta.spartagoods.dto.item.ItemResponseDto;
import com.sparta.spartagoods.service.ItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;

    @PostMapping
    @Secured("ROLE_ADMIN")
    public ResponseEntity<ItemResponseDto> createItem(@Valid @RequestBody ItemRequestDto requestDto ) {
        return itemService.createItem(requestDto);
    }

    @GetMapping("/{itemId}")
    public ResponseEntity<ItemResponseDto> findItem(@PathVariable Long itemId){
        return itemService.findItem(itemId);
    }

    @ResponseBody
    @GetMapping
    public ResponseEntity<Page<ItemResponseDto>> listItem(
            @RequestParam(name = "standard") String standard,
            @RequestParam(name = "orderBy") String orderBy,
            @RequestParam(name = "page") int page,
            @RequestParam(name = "pagenum") int pageNum) {
        return itemService.listItem(standard, orderBy, page, pageNum);
    }
}