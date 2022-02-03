package com.sparta.blog.service;

import com.sparta.blog.dto.BoardDto;
import com.sparta.blog.model.Board;
import com.sparta.blog.model.User;
import com.sparta.blog.repository.BoardRepository;
import com.sparta.blog.repository.ReplyRepository;
import com.sparta.blog.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;// 초기값이 저장되면 최종적인 값이 되어 프로그램 실행 도중에 수정을 할 수 없다
    private final ReplyRepository replyRepository;


    @Transactional//데이터베이스의 상태를 변경하는 작업 또는 한번에 수행되어야 하는 연산
    public Board createBoard(BoardDto boardDto, User user){
        Board createdBoard = Board.builder()
                .id(boardDto.getId())
                .content(boardDto.getContent())
                .username(user.getUsername())
                .title(boardDto.getTitle())
                .build();

        return boardRepository.save(createdBoard);
    }



    public List<Board> getList(){

        return boardRepository.findAllByOrderByModifiedAt();
    }

    public Optional<Board> getOne(Long id){


        return boardRepository.findById(id);
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detailPage(@PathVariable("id") Long Id, @AuthenticationPrincipal UserDetailsImpl userDetails){
        Optional<Board> board = boardRepository.findById(Id);
        ModelAndView modelAndView = new ModelAndView("detail.html");
        modelAndView.addObject("id", board.get().getId());
        modelAndView.addObject("title", board.get().getTitle());
        modelAndView.addObject("username", board.get().getUsername());
        modelAndView.addObject("contents", board.get().getContent());
        modelAndView.addObject("createdAt", board.get().getCreatedAt());
        modelAndView.addObject("modifiedAt", board.get().getModifiedAt());
        return modelAndView;
    }


//    @Transactional
//    public void deleteBoard(Integer id) {
//        boardRepository.deleteById(id);
//    }


}
