/*
package com.example.springaichatbox.controller;

import com.example.springaichatbox.dto.Countries;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import reactor.core.publisher.Flux;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.contains;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ChatBotController.class)
public class ChatBotControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean(answer = Answers.RETURNS_DEEP_STUBS)
    private ChatClient chatClient;

    @Before
    public void setup() {
        // no-op
    }

    @Test
    public void generateEndpoint_returnsAiResponse() throws Exception {
        Mockito.when(chatClient
                .prompt()
                .user(eq("hello"))
                .call()
                .content())
                .thenReturn("ai response");

        mockMvc.perform(get("/ai/generate").param("userPrompt", "hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("ai response"));
    }

    @Test
    public void countriesEndpoint_returnsCountriesJson() throws Exception {
        Countries countries = new Countries();
        Mockito.when(chatClient
                .prompt()
                .user(contains("Provide a list of countries"))
                .call()
                .entity(eq(Countries.class)))
                .thenReturn(countries);

        mockMvc.perform(get("/ai/countries").param("region", "Asia")).andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{}"));
    }

    @Test
    public void generateStream_returnsFlux() throws Exception {
        Flux<String> flux = Flux.just("a","b");
        Mockito.when(chatClient
                .prompt()
                .user(eq("stream"))
                .stream()
                .content())
                .thenReturn(flux);

        mockMvc.perform(get("/ai/generateStream").param("userPrompt","stream"))
                .andExpect(status().isOk());
    }

    @Test
    public void generateChatResponse_returnsChatResponse() throws Exception {
        ChatResponse chatResponse = Mockito.mock(ChatResponse.class);
        Mockito.when(chatClient
                .prompt()
                .user(eq("chat"))
                .call()
                .chatResponse())
                .thenReturn(chatResponse);

        mockMvc.perform(get("/ai/generateChatResponse").param("userPrompt","chat"))
                .andExpect(status().isOk());
    }
}

*/
