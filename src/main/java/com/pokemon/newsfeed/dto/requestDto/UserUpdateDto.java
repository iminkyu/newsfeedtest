package com.pokemon.newsfeed.dto.requestDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class UserUpdateDto {

    @NotBlank
    private String name;
    @NotBlank
    private String userId;
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    @NotBlank
    private String confirmPassword;
}
