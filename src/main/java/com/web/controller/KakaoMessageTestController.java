package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/kakao/msg")
public class KakaoMessageTestController {

    @GetMapping({"", "/"})
    public String index() {

        return "/kakao/kakaoMessageTalk";
    }
}
