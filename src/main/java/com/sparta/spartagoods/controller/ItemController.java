package com.sparta.spartagoods.controller;

import com.amazonaws.services.ec2.model.ResponseError;
import com.sparta.spartagoods.dto.ResponseDto;
import com.sparta.spartagoods.dto.item.ItemRequestDto;
import com.sparta.spartagoods.dto.item.ItemResponseDto;
import com.sparta.spartagoods.service.ItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@Tag(name = "상품 컨트롤러", description = "상품 등록, 조회, 리스트 조회")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;

    @Operation(summary = " 상품 등록 ", description = "상품 등록을 합니다")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "상품 등록 성공", content = @Content(schema = @Schema(implementation = ItemResponseDto.class))),
            @ApiResponse(responseCode = "401", description = "인가 기능이 확인되지 않은 접근", content = @Content(schema = @Schema(implementation = ResponseError.class))),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 리소스 접근", content = @Content(schema = @Schema(implementation = ResponseError.class))),
            @ApiResponse(responseCode = "500", description = "서버 오류 발생", content = @Content(schema = @Schema(implementation = ResponseError.class)))
    })
    @PostMapping
    @Secured("ROLE_ADMIN")
    public ResponseEntity<ItemResponseDto> createItem(@Valid @RequestBody ItemRequestDto requestDto ) {
        return itemService.createItem(requestDto);
    }

    @Operation(summary = "상품 찾기", description = "상품 아이디를 통해 상품을 찾습니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "상품 찾기 성공", content = @Content(schema = @Schema(implementation = ItemResponseDto.class))),
            @ApiResponse(responseCode = "401", description = "인가 기능이 확인되지 않은 접근", content = @Content(schema = @Schema(implementation = ResponseError.class))),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 리소스 접근", content = @Content(schema = @Schema(implementation = ResponseError.class))),
            @ApiResponse(responseCode = "500", description = "서버 오류 발생", content = @Content(schema = @Schema(implementation = ResponseError.class)))
    })
    @GetMapping("/{itemId}")
    public ResponseEntity<ItemResponseDto> findItem(@PathVariable Long itemId){
        return itemService.findItem(itemId);
    }


    @Operation(summary = "상품을 리스트 형태로 반환합니다.", description = "정렬 기준 : 가격 or 상품 이름. & 오름차순. 내림차순 설정 가능.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "상품 리스트 반환 성공", content = @Content(schema = @Schema(implementation = ItemResponseDto.class))),
            @ApiResponse(responseCode = "401", description = "인가 기능이 확인되지 않은 접근", content = @Content(schema = @Schema(implementation = ResponseError.class))),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 리소스 접근", content = @Content(schema = @Schema(implementation = ResponseError.class))),
            @ApiResponse(responseCode = "500", description = "서버 오류 발생", content = @Content(schema = @Schema(implementation = ResponseError.class)))
    })
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