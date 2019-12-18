package com.apitest.answer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(AnswerController.class)
public class AnswerControllerTest {

    private MockMvc mockMvc;

    @Mock
    private APIService mockService;

    @InjectMocks
    private AnswerController answerController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(answerController).build();
    }

    @Test
    public void validGetLondonersRequest() throws Exception {
        String data = "[{\"last_name\": \"WithinFiftyMilesOfLondon\"}, {\"last_name\": \"Last2\"}, {\"last_name\": \"Last3\"}]";
        String uri = "/londoners";
        Mockito.when(mockService.getLondonUsers())
                .thenReturn(data);

        mockMvc.perform(get(uri))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].last_name", is("WithinFiftyMilesOfLondon")));
    }

    @Test
    public void validGetLondonersRequestReturnsNoUsers() throws Exception {
        String data = "[]";
        String uri = "/londoners";
        Mockito.when(mockService.getLondonUsers())
                .thenReturn(data);

        mockMvc.perform(get(uri))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)))
                .andExpect(content().string("[]"));
    }

    @Test
    public void validGetUsersNearLondonRequest() throws Exception {
        String data = "[{\"last_name\": \"WithinFiftyMilesOfLondon\"}]";
        String uri = "/nearlondon";
        Mockito.when(mockService.getUsersCloseToLondon())
                .thenReturn(data);

        mockMvc.perform(get(uri))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].last_name", is("WithinFiftyMilesOfLondon")));

    }

    @Test
    public void validGetUsersNearLondonRequestReturnsNoUsers() throws Exception {
        String data = "[]";
        String uri = "/nearlondon";
        Mockito.when(mockService.getUsersCloseToLondon())
                .thenReturn(data);

        mockMvc.perform(get(uri))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)))
                .andExpect(content().string("[]"));

    }

    @Test
    public void getLondonersRequestThrowsAnError() throws Exception {
        RuntimeException ex = new RuntimeException("Failed : HTTP error code : 404");
        String expectedError = "Unable to to get lonodon users : " + ex.getMessage();
        String uri = "/londoners";
        Mockito.when(mockService.getLondonUsers())
                .thenThrow(ex);

        MvcResult result = mockMvc.perform(get(uri))
                .andExpect(status().is4xxClientError())
                .andReturn();

        Assert.assertEquals(expectedError, result.getResponse().getErrorMessage());
    }

    @Test
    public void getUsersNearLondonRequestThrowsAnError() throws Exception {
        RuntimeException ex = new RuntimeException("Failed : HTTP error code : 404");
        String expectedError = "Unable to to get users within fifty miles of London : " + ex.getMessage();
        String uri = "/nearlondon";
        Mockito.when(mockService.getUsersCloseToLondon())
                .thenThrow(ex);

        MvcResult result = mockMvc.perform(get(uri))
                .andExpect(status().is4xxClientError())
                .andReturn();

        Assert.assertEquals(expectedError, result.getResponse().getErrorMessage());
    }
}

