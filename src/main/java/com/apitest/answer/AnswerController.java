package com.apitest.answer;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@RestController
public class AnswerController {

    APIService service = new APIService();

    @RequestMapping("/londoners")
    String getLondoners(){
        try {
            return service.getLondonUsers();
        } catch (Exception e) {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Unable to to get lonodon users : " + e.getMessage(), e);
        }
    }

    @RequestMapping("/nearlondon")
    String getNearLondon()  {
        try {
            return service.getUsersCloseToLondon();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to to get users within fifty miles of London : " + e.getMessage(), e);
        }
    }
}
