package com.pokemon.newsfeed.dto.responseDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class SignupResponseDto {
    private String userId;
    private String password;
    private String email;
    private String name;
}
