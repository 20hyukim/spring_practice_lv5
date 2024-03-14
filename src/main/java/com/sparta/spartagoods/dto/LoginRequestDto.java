package com.sparta.spartagoods.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDto{

    @Schema(description = "이메일", nullable = false, example = "potato@naver.com")
    @Email
    @NotBlank
    private String email;

    @Schema(description = "비밀 번호", nullable = false, example = "ILOVEPOTATO")
    @NotBlank
    @Size(min = 8, max = 15)
    private String password;
}
