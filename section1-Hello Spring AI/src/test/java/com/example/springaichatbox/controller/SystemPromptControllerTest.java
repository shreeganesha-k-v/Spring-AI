/*
package com.example.springaichatbox.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(SystemPromptController.class)
public class SystemPromptControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean(answer = Answers.RETURNS_DEEP_STUBS)
    private ChatClient chatClient;

    @Before
    public void setup() {
        // No-op
    }

    @Test
    public void systemPrompt_returnsResponse() throws Exception {
        Mockito.when(chatClient
                .prompt()
                .system(Mockito.anyString())
                .user(Mockito.any())
                .call()
                .content()).thenReturn("system response");

        mockMvc.perform(get("/ai/systemPrompt").param("userPrompt","Java"))
                .andExpect(status().isOk())
                .andExpect(content().string("system response"));
    }
}

*/
