package com.example.springtwitter;

import com.example.springtwitter.Resources.controller;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest

@ExtendWith(SpringExtension.class)
public class controllerTest {
    @Autowired
    private static MockMvc mockMvc;
    @BeforeAll
    static void init () {
        mockMvc = MockMvcBuilders.standaloneSetup(controller.class).build();
    }
    @Test
    public void testGettingTimeline() throws Exception {
        mockMvc.perform(get("/api/1.0/twitter/timeline")).andDo(print()).andExpect(status().isOk());
    }
    @Test
    public void testPostTweet() throws Exception {

        mockMvc.perform(post("/api/1.0/twitter/tweet")
                        .contentType(MediaType.ALL)
                        .content("Successfully updated tweet.Check the twitter account to see the post").characterEncoding("utf-8"))
                .andExpect(status().isOk());

    }


}

