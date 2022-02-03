package com.sparta.blog.dto;


import com.sparta.blog.model.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDto {
        private Long id;
        private String title;
        private String username;
        private String content;




}



