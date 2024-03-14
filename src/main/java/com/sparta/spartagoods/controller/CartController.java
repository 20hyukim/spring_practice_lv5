package com.sparta.spartagoods.controller;

import com.amazonaws.services.ec2.model.ResponseError;
import com.sparta.spartagoods.dto.ResponseDto;
import com.sparta.spartagoods.dto.cart.CartRequestDto;
import com.sparta.spartagoods.dto.cart.CartResponseDto;
import com.sparta.spartagoods.dto.cart.TotalCartResponseDto;
import com.sparta.spartagoods.dto.item.ItemRequestDto;
import com.sparta.spartagoods.entity.user.User;
import com.sparta.spartagoods.security.UserDetailsImpl;
import com.sparta.spartagoods.service.CartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Tag(name = "장바구니 컨트롤러", description = "장바구니 등록, 조회, 편집, 삭제")
@RestController
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    @Operation(summary = "상품 장바구니 넣기", description = "장바구니에 상품을 넣습니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "장바구니 넣기 성공", content = @Content(schema = @Schema(implementation = CartResponseDto.class))),
            @ApiResponse(responseCode = "401", description = "인가 기능이 확인되지 않은 접근", content = @Content(schema = @Schema(implementation = ResponseError.class))),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 리소스 접근", content = @Content(schema = @Schema(implementation = ResponseError.class))),
            @ApiResponse(responseCode = "500", description = "서버 오류 발생", content = @Content(schema = @Schema(implementation = ResponseError.class)))
    })
    @PostMapping
    @Secured("ROLE_ADMIN")
    public ResponseEntity<CartResponseDto> addCart(@Valid @RequestBody CartRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
        return cartService.addCart(requestDto, userDetails);
    }

    @Operation(summary = "장바구니 보기", description = "장바구니 조회를 합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "장바구니 조회 성공", content = @Content(schema = @Schema(implementation = TotalCartResponseDto.class))),
            @ApiResponse(responseCode = "401", description = "인가 기능이 확인되지 않은 접근", content = @Content(schema = @Schema(implementation = ResponseError.class))),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 리소스 접근", content = @Content(schema = @Schema(implementation = ResponseError.class))),
            @ApiResponse(responseCode = "500", description = "서버 오류 발생", content = @Content(schema = @Schema(implementation = ResponseError.class)))
    })
    @GetMapping
    @Secured("ROLE_ADMIN")
    public ResponseEntity<TotalCartResponseDto> viewCart(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return cartService.viewCart(userDetails);
    }

    @Operation(summary = "장바구니 수정", description = "장바구니 정보 수정을 합니다")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "장바구니 수정 성공", content = @Content(schema = @Schema(implementation = Object.class))),
            @ApiResponse(responseCode = "401", description = "인가 기능이 확인되지 않은 접근", content = @Content(schema = @Schema(implementation = ResponseError.class))),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 리소스 접근", content = @Content(schema = @Schema(implementation = ResponseError.class))),
            @ApiResponse(responseCode = "500", description = "서버 오류 발생", content = @Content(schema = @Schema(implementation = ResponseError.class)))
    })
    @PatchMapping
    @Secured("ROLE_ADMIN")
    public ResponseEntity<Object> editCart(
            @RequestParam(name = "cartId") Long cartID,
            @RequestParam(name = "count") Long count,
            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return cartService.editCart(cartID, count, userDetails);
    }

    @Operation(summary = "장바구니 삭제", description = "장바구니 삭제를 합니다")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "장바구니 삭제 성공", content = @Content(schema = @Schema(implementation = Object.class))),
            @ApiResponse(responseCode = "401", description = "인가 기능이 확인되지 않은 접근", content = @Content(schema = @Schema(implementation = ResponseError.class))),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 리소스 접근", content = @Content(schema = @Schema(implementation = ResponseError.class))),
            @ApiResponse(responseCode = "500", description = "서버 오류 발생", content = @Content(schema = @Schema(implementation = ResponseError.class)))
    })
    @DeleteMapping("/{cartId}")
    @Secured("ROLE_ADMIN")
    public ResponseEntity<Object> deleteCart(@PathVariable Long cartId, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return cartService.deleteCart(cartId, userDetails);
    }


}
