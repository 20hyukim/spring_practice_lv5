package com.sparta.spartagoods.service;

import com.sparta.spartagoods.dto.ResponseDto;
import com.sparta.spartagoods.dto.SignupRequestDto;
import com.sparta.spartagoods.entity.user.User;
import com.sparta.spartagoods.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Transactional
    public ResponseEntity<ResponseDto> signup(SignupRequestDto requestDto) {
        Optional<User> optionalUser = userRepository.findByEmail(requestDto.getEmail());
        if(optionalUser.isPresent()){
            return new ResponseEntity<>(new ResponseDto("이미 존재하는 회원입니다."), HttpStatus.BAD_REQUEST);
        }
        //PW
        String encodedPassword = passwordEncoder.encode(requestDto.getPassword());
        User user = new User(requestDto, encodedPassword);
        userRepository.save(user);
        return new ResponseEntity<>(new ResponseDto("회원가입 완료이 완료되었습니다."), HttpStatus.OK);



    }
}
