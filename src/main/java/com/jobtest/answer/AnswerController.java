package com.jobtest.answer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AnswerController {

    @RequestMapping("/londoners")
    String getLondoners(Model model) {
        String title = "List of users from London";
        String tabText = "London users";
        model.addAttribute("Title", title);
        model.addAttribute("TabText", tabText);
        model.addAttribute("users", (Londoners.getLondonUsers()));
        return "results.html";
    }

    @RequestMapping("/nearlondon")
    String getNearLondon(Model model) {
        String title = "List of users from within 50 miles of London";
        String tabText = "Users within 50 miles of London";
        model.addAttribute("Title", title);
        model.addAttribute("TabText", tabText);
        model.addAttribute("users", (CloseToLondon.getUsersCloseToLondon()));
        return "results.html";
    }
}
