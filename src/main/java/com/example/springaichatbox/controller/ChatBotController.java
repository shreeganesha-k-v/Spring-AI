package com.example.springaichatbox.controller;

import com.example.springaichatbox.dto.Countries;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

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

        // Map response to a DTO
        @GetMapping("/countries")
        public ResponseEntity<Countries> getCountriesList(@RequestParam String region){
                Countries countries = chatClient
                        .prompt()
                        .user("Provide a list of countries in the region: " + region + " in JSON format.")
                        .call()
                        .entity(Countries.class);
                return ResponseEntity.ok(countries);
        }

        //Generate a stream response similar to how chatGpt or other models do it
        @GetMapping("/generateStream")
        public ResponseEntity<Flux<String>> getStreamedResponse(@RequestParam String userPrompt){
                Flux<String> response = chatClient
                        .prompt()
                        .user(userPrompt)
                        .stream()
                        .content();
                return ResponseEntity.ok(response);
        }

        @GetMapping("generateChatResponse")
        public ResponseEntity<ChatResponse> getChatResponse(@RequestParam String userPrompt){
                ChatResponse response = chatClient
                        .prompt()
                        .user(userPrompt)
                        .call()
                        .chatResponse();
                return ResponseEntity.ok(response);
        }



}
