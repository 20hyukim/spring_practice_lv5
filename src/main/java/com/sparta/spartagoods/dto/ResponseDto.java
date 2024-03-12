package com.sparta.spartagoods.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
public class ResponseDto {
    private final String message;

    public ResponseDto(String message) {
        this.message = message;
    }
}
