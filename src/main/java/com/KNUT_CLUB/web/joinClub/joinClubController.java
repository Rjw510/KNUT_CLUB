package com.KNUT_CLUB.web.joinClub;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class joinClubController {

    @GetMapping("/joinClub/chungju")
    public String goChungju() {
        return "joinClub/chungju";
    }

    @GetMapping("/joinClub/jeungpyeong")
    public String goJeungpyeong() {
        return "joinClub/jeungpyeong";
    }

    @GetMapping("/joinClub/uiwang")
    public String goUiwang() {
        return "joinClub/uiwang";
    }
}
