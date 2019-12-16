package com.jobtest.answer;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AnswerController.class)
class AnswerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private Londoners mockLondoners;

    @Test
    void getLondoners() throws Exception {

        String data = "[{\"last_name\": \"WithinFiftyMilesOfLondon\"}, {\"last_name\": \"Last2\"}, {\"last_name\": \"Last3\"}]";
        when(mockLondoners.getLondonUsers()).thenReturn(data);

        String uri = "/londoners";

        this.mockMvc.perform(get(uri)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("WithinFiftyMilesOfLondon")));
    }

    @Test
    void getNearLondon() {
    }
}