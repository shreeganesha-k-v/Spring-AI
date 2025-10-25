package com.example.springaichatbox.controller;

import com.example.springaichatbox.dto.Countries;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai")
@RequiredArgsConstructor
public class ChatBotController {

        private final ChatClient chatClient;

        @GetMapping("/generate")
        public ResponseEntity<String> getCountries(@RequestParam String userPrompt){
                String response = chatClient
                        .prompt()
                        .user(userPrompt)
                        .call()
                        .content();
                return ResponseEntity.ok(response);
        }


}
