package com.KNUT_CLUB.web.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class CheckController {

    @GetMapping("/check")
    public String goCheck() {
        return "check";
    }

}
