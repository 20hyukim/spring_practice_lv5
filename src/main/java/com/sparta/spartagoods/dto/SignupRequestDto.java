package com.sparta.spartagoods.dto;

import com.sparta.spartagoods.entity.user.UserRoleEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequestDto {
    @Email
    @NotBlank
    @Schema(description = "사용자 이메일", nullable = false, example = "k12@gmail.com")
    private String email;

    @Schema(description = "비밀번호", nullable = false, example = "김감자")
    @NotBlank
    @Size(min = 8, max = 15)
    private String password;

    @Schema(description = "성별", nullable = false, example = "M or F")
    @NotBlank
    private String gender;

    @Schema(description = "사용자 핸드폰 번호", nullable = false, example = "010-12-31")
    @NotBlank
    private String phoneNumber;

    @Schema(description = "주소", nullable = false, example = "경기도 하남시 ...")
    @NotBlank
    private String address;

    @Schema(description = "권한", nullable = false, example = "ADMIN or USER")
    @NotBlank
    private UserRoleEnum role;
}
