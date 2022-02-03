package com.sparta.blog.Controller;


import com.sparta.blog.dto.ReplyDto;
import com.sparta.blog.model.Reply;
import com.sparta.blog.repository.ReplyRepository;
import com.sparta.blog.service.ReplyService;
import com.sparta.blog.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@RestController
public class ReplyController {
    private final ReplyRepository replyRepository;
    private final ReplyService replyService;

    //코멘트 보여주기
    @GetMapping("/boards/{id}/reply")
    public List<Reply> getReply(@PathVariable("id") Long boardId) {
        //게시글 번호로 코멘트를 조회해서 해당하는 코멘트만 리턴
        return replyRepository.findByBoardIdOrderByModifiedAtDesc(boardId);
    }

    //코멘트 생성
    @PostMapping("/api/boards/{id}/reply")
    public Reply createReply(@RequestBody ReplyDto replyDto,@PathVariable("id") Long boardId, @AuthenticationPrincipal UserDetailsImpl userDetails){
        //생성시 생성자의 아이디를 받아 함께 저장
        System.out.println(boardId);

        Long userId = userDetails.getUser().getId();
        String username = userDetails.getUsername();
        Reply reply = new Reply(replyDto,userId,username,boardId);
        return replyRepository.save(reply);
    }

    //코멘트 수정
    @PutMapping("/api/boards/{boardId}/reply/{replyId}")
    public Long updateReply(@PathVariable Long replyId, @RequestBody ReplyDto requestDto){
        replyService.updateReply(replyId, requestDto);
        return replyId;
    }

    //코멘트 삭제
    @DeleteMapping("/api/boards/{boardId}/reply/{replyId}")
    public  String deleteReply(@PathVariable Long replyId,@AuthenticationPrincipal UserDetailsImpl userDetails){
        //삭제시 삭제자의 이름과 생성자의이름을 비교해 같으면 삭제 성공하도록 만들었는데 앞단에서 생성자,삭제자의 이름이 다르면 아예 버튼이 안보이도록 만들어서
        //필요없어짐
        String name = userDetails.getUser().getUsername();
        String replyUserName = replyRepository.findById(replyId).get().getUsername();
        if (Objects.equals(name, replyUserName)){
            replyRepository.deleteById(replyId);
        } else {
            return "삭제실패";
        }
        return "삭제성공";
    }
}
