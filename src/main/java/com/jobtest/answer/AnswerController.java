package com.jobtest.answer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AnswerController {

    APIService service = new APIService();

    @RequestMapping("/londoners")
    String getLondoners(){
        try {
            return service.getLondonUsers();
        } catch (Exception e) {
            throw new RuntimeException("Unable to to get lonond users :" + e.getMessage());
        }
    }

    @RequestMapping("/nearlondon")
    String getNearLondon()  {
        try {
            return service.getUsersCloseToLondon();
        } catch (Exception e) {
            throw new RuntimeException("Unable to to get users within fifty miles of London :" + e.getMessage());
        }
    }
}
