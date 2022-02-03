package com.sparta.blog.Controller;

import com.sparta.blog.dto.BoardDto;
import com.sparta.blog.model.Board;
import com.sparta.blog.repository.BoardRepository;
import com.sparta.blog.security.UserDetailsImpl;
import com.sparta.blog.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@RestController
public class BoardRestController {

    private final BoardService boardService;
    private final BoardRepository boardRepository;


    @GetMapping("/api/boards")
    public List<Board> getLists() {
        return boardService.getList();
    }


    @GetMapping("/api/boards/{id}")
    public Optional<Board> getOne(@PathVariable Long id) {
        return boardService.getOne(id);
    }
//만약 뒤에 넘버형식이 아닌 파라메터의 값과 이름을 함께 전  달하는 방식으로 사용할경우 RequestParam쓰기
//pahtvariable 같은 경우  Rest api 에서 값을 호출 할 때 주로쓰인다고한다.


    @PostMapping("/api/boards")
    public Board createBoard(@RequestBody BoardDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {

        return boardService.createBoard(requestDto, userDetails.getUser());
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detailPage(@PathVariable("id") Long Id, @AuthenticationPrincipal UserDetailsImpl userDetails){
        Optional<Board> board = boardRepository.findById(Id);
        ModelAndView modelAndView = new ModelAndView("detail.html");
        modelAndView.addObject("id", board.get().getId());
        modelAndView.addObject("title", board.get().getTitle());
        modelAndView.addObject("username", board.get().getUsername());
        modelAndView.addObject("content", board.get().getContent());
        modelAndView.addObject("createdAt", board.get().getCreatedAt());
        modelAndView.addObject("modifiedAt", board.get().getModifiedAt());
        return modelAndView;
    }


//    @DeleteMapping("/api/boards")
//    public Board deleteBoard(@RequestBody BoardDto requestDto) {
//
//        return boardService.deleteBoard(requestDto);
//    }
}

