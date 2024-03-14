package com.sparta.spartagoods.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
public class ResponseDto {

    @Schema(description = "반환 메시지", nullable = false, example = "가입이 완료되었습니다.")
    private final String message;

    public ResponseDto(String message) {
        this.message = message;
    }
}
