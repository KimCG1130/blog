package com.sparta.blog.Controller;

import com.sparta.blog.dto.BoardDto;
import com.sparta.blog.model.Board;
import com.sparta.blog.repository.BoardRepository;
import com.sparta.blog.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardRepository boardRepository;

    @GetMapping("/")
    public String home() {
        return "index";
    }

//    @PostMapping("/api/boards")
//    public Board createBoard(@RequestBody BoardDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
//        Long userId = userDetails.getUser().getId();
//        Board board = new Board(requestDto, userId, userDetails.getUsername());
//        return boardRepository.save(board);
//    }
//
//    //게시글 생성 페이지 이동
//    @RequestMapping("/write")
//    public ModelAndView write() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("write.html");
//        return modelAndView;
//    }
//
//    //게시글 전체 조회
//    @GetMapping("/api/articles")
//    public List<Board> getBoards() {return BoardRepository.findAllByOrderByModifiedAtDesc();}
//
    //게시글 상세페이지 조회
//    @GetMapping("/detail/{id}")
//    public ModelAndView detailPage(@PathVariable("id") Long Id, @AuthenticationPrincipal UserDetailsImpl userDetails){
//        Optional<Board> board = boardRepository.findById(Id);
//        ModelAndView modelAndView = new ModelAndView("detail.html");
//        modelAndView.addObject("id", board.get().getId());
//        modelAndView.addObject("title", board.get().getTitle());
//        modelAndView.addObject("username", board.get().getUsername());
//        modelAndView.addObject("content", board.get().getContent());
//        modelAndView.addObject("createdAt", board.get().getCreatedAt());
//        modelAndView.addObject("modifiedAt", board.get().getModifiedAt());
//        return modelAndView;
//    }


}
