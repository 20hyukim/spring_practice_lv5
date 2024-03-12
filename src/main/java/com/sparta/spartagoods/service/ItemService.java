package com.sparta.spartagoods.service;

import com.sparta.spartagoods.dto.item.ItemRequestDto;
import com.sparta.spartagoods.dto.item.ItemResponseDto;
import com.sparta.spartagoods.entity.item.Item;
import com.sparta.spartagoods.repository.ItemRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;


@Slf4j
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


    @Transactional(readOnly = true)
    public ResponseEntity<Page<ItemResponseDto>> listItem(String standard, String orderBy, int page, int pageNum) {
        int pageIndex = page - 1;
        int pageSize = pageNum;

        if (!Objects.equals(standard, "price") && !Objects.equals(standard, "itemName")) {
            throw new IllegalArgumentException("설정한 기준이 올바르지 않습니다. price 또는 itemName으로 설정해 주세요.");
        }

        if (!Objects.equals(orderBy, "asc") && !Objects.equals(orderBy, "desc")){
           throw new IllegalArgumentException("설정한 정렬 기준이 올바르지 않습니다. desc 또는 asc으로 설정해 주세요");
        }

        Sort.Direction sortDirection = "desc".equalsIgnoreCase(orderBy) ? Sort.Direction.DESC : Sort.Direction.ASC;
        PageRequest pageRequest = PageRequest.of(pageIndex, pageSize, Sort.by(sortDirection, standard));
        Page<Item> itemPages = itemRepository.findAll(pageRequest);
        Page<ItemResponseDto> itemResponseDtos = itemPages.map(ItemResponseDto::new);
        return ResponseEntity.ok(itemResponseDtos);
    }
}
