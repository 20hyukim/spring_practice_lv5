package com.sparta.spartagoods.dto;

import com.sparta.spartagoods.entity.user.UserRoleEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequestDto {
    @Email
    @NotBlank
    private String email;
    @NotBlank
    @Size(min = 8, max = 15)
    private String password;
    @NotBlank
    private String gender;
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String address;
    @NotBlank
    private UserRoleEnum role;
}
