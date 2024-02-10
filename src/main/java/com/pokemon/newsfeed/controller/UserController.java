package com.pokemon.newsfeed.controller;

import com.pokemon.newsfeed.dto.requestDto.SignupRequestDto;
import com.pokemon.newsfeed.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.SocketTimeoutException;
import java.util.List;

@Slf4j
@RestController
public class UserController {

    private final UserService userService;

    public UserController (UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users/signup")
    public String signup (@Valid @RequestBody SignupRequestDto requestDto, BindingResult bindingResult) {
        // todo: RequestBody 어노테이션 없으면 null이 들어오는 이유
        System.out.println(requestDto);
        // Validation 예외처리
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        if (!fieldErrors.isEmpty()) {
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                log.error(fieldError.getField() + " 필드 : " + fieldError.getDefaultMessage());
            }
            return "회원가입도중 에러가 발생했습니다.";
        }

        System.out.println(requestDto);
        userService.signup(requestDto);

        return "회원가입 성공";
    }
}
