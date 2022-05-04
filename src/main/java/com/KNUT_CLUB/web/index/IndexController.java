package com.KNUT_CLUB.web.index;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class IndexController {

    @GetMapping("/index")
    public String goIndex() {
        return "index/index";
    }

    @GetMapping("/adminIndex")
    public String goAdminIndex() {
        return "index/adminIndex";
    }
}
