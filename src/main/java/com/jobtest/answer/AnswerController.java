package com.jobtest.answer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AnswerController {

    @RequestMapping("/londoners")
    String getLondoners() throws Exception {
        Londoners londoners = new Londoners();
        return londoners.getLondonUsers();
    }

    @RequestMapping("/nearlondon")
    String getNearLondon() throws Exception {
        NearToLondon nearToLondon = new NearToLondon();
        return nearToLondon.getUsersCloseToLondon();
    }
}
