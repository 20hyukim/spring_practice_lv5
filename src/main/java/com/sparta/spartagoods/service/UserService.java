package com.sparta.spartagoods.service;

import com.sparta.spartagoods.dto.ResponseDto;
import com.sparta.spartagoods.dto.SignupRequestDto;
import com.sparta.spartagoods.entity.User.User;
import com.sparta.spartagoods.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<ResponseDto> signup(SignupRequestDto requestDto) {
        Optional<User> optionalUser = userRepository.findByEmail(requestDto.getEmail());
        if(optionalUser.isPresent()){
            return new ResponseEntity<>(new ResponseDto("이미 존재하는 회원입니다."), HttpStatus.BAD_REQUEST);
        }

        User user = new User(requestDto);
        userRepository.save(user);
        return new ResponseEntity<>(new ResponseDto("회원가입 완료이 완료되었습니다."), HttpStatus.OK);
    }
}
