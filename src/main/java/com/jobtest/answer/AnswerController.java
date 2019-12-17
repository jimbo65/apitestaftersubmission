package com.jobtest.answer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AnswerController {

    APIService service = new APIService();

    @RequestMapping("/londoners")
    String getLondoners() throws Exception {
        return service.getLondonUsers();
    }

    @RequestMapping("/nearlondon")
    String getNearLondon() throws Exception {
        return service.getUsersCloseToLondon();
    }
}
