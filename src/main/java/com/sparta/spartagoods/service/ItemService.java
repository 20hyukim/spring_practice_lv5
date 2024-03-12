package com.sparta.spartagoods.service;

import com.sparta.spartagoods.dto.item.ItemRequestDto;
import com.sparta.spartagoods.dto.item.ItemResponseDto;
import com.sparta.spartagoods.entity.item.Item;
import com.sparta.spartagoods.repository.ItemRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public ResponseEntity<ItemResponseDto> createItem(@Valid ItemRequestDto requestDto) {
        Item item = new Item(requestDto);
        itemRepository.save(item);
        return ResponseEntity.ok(new ItemResponseDto(item));
    }

    @Transactional
    public ResponseEntity<ItemResponseDto> findItem(Long itemId) {
        Item item = itemRepository.findById(itemId).orElseThrow(() -> new IllegalArgumentException("해당 상품을 찾을 수 없습니다."));
        return ResponseEntity.ok(new ItemResponseDto(item));
    }


}
