package com.pokemon.newsfeed.dto.responseDto;

import lombok.Getter;

@Getter
public class ProfileResponseDto {

    private String name;
    private String userId;
    private String email;

    public ProfileResponseDto(String name, String userId, String email) {
        this.name = name;
        this.userId = userId;
        this.email = email;
    }
}
