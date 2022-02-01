package com.sparta.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class KakaoUserInfoDto {
    private final Long id;
    private String nickname;
    private String email;
}

