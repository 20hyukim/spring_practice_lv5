package com.sparta.spartagoods.entity.user;

import com.sparta.spartagoods.dto.SignupRequestDto;
import com.sparta.spartagoods.entity.cart.Cart;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "user")
    private List<Cart> userCart = new ArrayList<>();


    public User(SignupRequestDto requestDto, String encodedPassword) {
        this.email = requestDto.getEmail();
        this.password = encodedPassword;
        this.gender = requestDto.getGender();
        this.phoneNumber = requestDto.getPhoneNumber();
        this.address = requestDto.getPhoneNumber();
        this.role = requestDto.getRole();
    }
}