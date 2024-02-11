package com.pokemon.newsfeed.service;

import com.pokemon.newsfeed.dto.requestDto.SignupRequestDto;
import com.pokemon.newsfeed.entity.User;
import com.pokemon.newsfeed.entity.UserRoleEnum;
import com.pokemon.newsfeed.repository.UserRepository;
import com.pokemon.newsfeed.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    public void signup(SignupRequestDto requestDto) {
        System.out.println(requestDto);
        // 회원 중복 체크
        String userId = requestDto.getUserId();
        Optional<User> checkUserId = userRepository.findByUserId(userId);
        if (checkUserId.isPresent()) {
            throw new IllegalArgumentException("중복된 아이디가 존재합니다.");
        }

        String password = passwordEncoder.encode(requestDto.getPassword());
        // 받아온 비밀번호 암호화

        // email 중복 체크
        String email = requestDto.getEmail();
        Optional<User> checkEmail = userRepository.findByEmail(email);
        if (checkEmail.isPresent()) {
            throw new IllegalArgumentException("중복된 이메일이 존재합니다.");
        }

        String name = requestDto.getName();
        UserRoleEnum role = UserRoleEnum.USER;

        // 사용자 등록
        User user = new User(userId, password, email, name, role);
        userRepository.save(user);
    }
}
