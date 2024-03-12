package com.sparta.spartagoods.service;

import com.sparta.spartagoods.dto.item.ItemRequestDto;
import com.sparta.spartagoods.dto.item.ItemResponseDto;
import com.sparta.spartagoods.entity.item.Item;
import com.sparta.spartagoods.repository.ItemRepository;
import jakarta.validation.Valid;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
