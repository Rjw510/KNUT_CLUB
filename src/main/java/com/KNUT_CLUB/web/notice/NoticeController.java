package com.KNUT_CLUB.web.notice;

import com.KNUT_CLUB.domain.notice.Notice;
import com.KNUT_CLUB.domain.notice.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class NoticeController {

    @GetMapping("/notice")
    public String goNotice() {
        return "notice";
    }

    /*@RequestParam("p") String page_*/
    @GetMapping ("/notice/noticeList")
    public String getNotice(@RequestParam("select") String field_, @RequestParam("word") String query_,
                            Model model) {

        String field = "title";
        if (field_ != null && !field_.equals(""))
            field = field_;

        String query = "";
        if (query_ != null && !query_.equals(""))
            query = query_;

        NoticeService service = new NoticeService();
        List<Notice> list = service.getNoticeList(field, query);
        int count = service.getNoticeCount(field, query);

        return "notice";
    }

    @GetMapping ("/board")
    public String goBoard(@RequestParam(value = "search")String search) {
        System.out.println(search);
        return "board";
    }




}
