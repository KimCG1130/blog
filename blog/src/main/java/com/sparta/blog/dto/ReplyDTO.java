package com.sparta.blog.dto;

import com.sparta.blog.model.Board;
import com.sparta.blog.model.Reply;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReplyDTO {

    private String content;


}
