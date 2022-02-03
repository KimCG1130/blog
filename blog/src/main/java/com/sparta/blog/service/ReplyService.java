package com.sparta.blog.service;

import com.sparta.blog.dto.ReplyDto;
import com.sparta.blog.model.Reply;
import com.sparta.blog.repository.ReplyRepository;
import com.sparta.blog.dto.ReplyDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class ReplyService {

    private final ReplyRepository replyRepository;

    public ReplyService(ReplyRepository replyRepository) {
        this.replyRepository = replyRepository;
    }

    @Transactional
    public void updateReply(Long replyId, ReplyDto requestDto){
        Reply reply = replyRepository.findById(replyId).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        reply.updateReply(requestDto);
    }
}

