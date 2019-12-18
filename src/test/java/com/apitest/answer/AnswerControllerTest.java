package com.apitest.answer;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(AnswerController.class)
public class AnswerControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AnswerController answerController;

    @Test
    public void answerControllerGetsLondoners() throws Exception {

        String data = "[{\"last_name\": \"WithinFiftyMilesOfLondon\"}, {\"last_name\": \"Last2\"}, {\"last_name\": \"Last3\"}]";

        String uri = "/londoners";
        given(answerController.getLondoners()).willReturn(data);

        mvc.perform(get(uri)
                .contentType(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].last_name", is("WithinFiftyMilesOfLondon")));
    }

    @Test
    public void answerControllerGetsUsersWithinFiftyMilesOfLondon() throws Exception {

        String data = "[{\"last_name\": \"WithinFiftyMilesOfLondon\"}]";

        String uri = "/nearlondon";
        given(answerController.getNearLondon()).willReturn(data);

        mvc.perform(get(uri)
                .contentType(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].last_name", is("WithinFiftyMilesOfLondon")));
    }

}