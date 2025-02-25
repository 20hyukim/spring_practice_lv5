package com.sparta.spartagoods.controller;

import com.amazonaws.services.ec2.model.ResponseError;
import com.sparta.spartagoods.dto.Image.ImageUploadResponse;
import com.sparta.spartagoods.dto.ResponseDto;
import com.sparta.spartagoods.entity.image.ImagePhoto;
import com.sparta.spartagoods.security.UserDetailsImpl;
import com.sparta.spartagoods.service.ImageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;

@Tag(name = "이미지 컨트롤러", description = "이미지 등록")
@RestController
@RequiredArgsConstructor
@RequestMapping("/image")
public class ImageController {

    private final ImageService imageService;

    @Operation(summary = "이미지 등록", description = "이미지 등록을 합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "이미지 등록 성공", content = @Content(schema = @Schema(implementation = ImageUploadResponse.class))),
            @ApiResponse(responseCode = "401", description = "인가 기능이 확인되지 않은 접근", content = @Content(schema = @Schema(implementation = ResponseError.class))),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 리소스 접근", content = @Content(schema = @Schema(implementation = ResponseError.class))),
            @ApiResponse(responseCode = "500", description = "서버 오류 발생", content = @Content(schema = @Schema(implementation = ResponseError.class)))
    })
    @PostMapping
    public ResponseEntity<ImageUploadResponse> saveImage(@RequestParam(value = "image") MultipartFile images,
                                                         @RequestParam(value = "item_itemId") Long itemId,
                                                         @AuthenticationPrincipal UserDetailsImpl userDetails
    ) throws IOException {
        return imageService.saveImage(images, itemId, userDetails);
    }
}
