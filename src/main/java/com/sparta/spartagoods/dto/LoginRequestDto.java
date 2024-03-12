package com.sparta.spartagoods.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDto{
    @Email
    @NotBlank
    private String email;
    @NotBlank
    @Size(min = 8, max = 15)
    private String password;
}
