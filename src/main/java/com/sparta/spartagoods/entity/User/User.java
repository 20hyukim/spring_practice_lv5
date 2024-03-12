package com.sparta.spartagoods.entity.User;

import com.sparta.spartagoods.dto.SignupRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserRoleEnum role;

    public User(SignupRequestDto requestDto) {
        this.email = requestDto.getEmail();
        this.password = requestDto.getPassword();
        this.gender = requestDto.getGender();
        this.phoneNumber = requestDto.getPhoneNumber();
        this.address = requestDto.getPhoneNumber();
    }
}