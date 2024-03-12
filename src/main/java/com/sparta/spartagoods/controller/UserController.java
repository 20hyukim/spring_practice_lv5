package com.sparta.spartagoods.controller;

import com.sparta.spartagoods.dto.ResponseDto;
import com.sparta.spartagoods.dto.SignupRequestDto;
import com.sparta.spartagoods.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/signup")
    public ResponseEntity<ResponseDto> signup(@RequestBody SignupRequestDto requestDto){
        return userService.signup(requestDto);
    }

    @GetMapping()
    @ResponseBody
    public String test(){
        return "12121";
    }
}
