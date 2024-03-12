package com.sparta.spartagoods.dto;

import lombok.Getter;
import lombok.Setter;

public class ResponseDto {
    private final String message;

    public ResponseDto(String message) {
        this.message = message;
    }
}
