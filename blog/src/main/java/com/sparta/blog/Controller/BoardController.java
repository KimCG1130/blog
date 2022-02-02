package com.sparta.blog.Controller;

import com.sparta.blog.security.UserDetailsImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
    @GetMapping("/")
    public String home() {
        return "index";
    }


}
