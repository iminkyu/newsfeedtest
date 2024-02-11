package com.pokemon.newsfeed.controller;

import com.pokemon.newsfeed.dto.requestDto.SignupRequestDto;
import com.pokemon.newsfeed.dto.responseDto.ProfileResponseDto;
import com.pokemon.newsfeed.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.net.SocketTimeoutException;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
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

    // 프로필 단건조회
    @GetMapping("/{num}")
    public ProfileResponseDto getProfile (@PathVariable Long num) {

        return userService.getProfile(num);
    }
}
