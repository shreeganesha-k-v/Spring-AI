package com.example.springaichatbox.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai")
@RequiredArgsConstructor
public class SystemPromptController {

    private final ChatClient chatClient;

    @GetMapping("/systemPrompt")
    public String getSystemPromptResponse(@RequestParam String userPrompt) {
        String systemPrompt = """
				Concept Explanation Guidelines:
				1. Length & Purpose:
				- Generate 300-word explanation that inform general audiences about the topic.
				2. Structure:
				- Body: Explain Why, What and How in 3 separate paragraphs with headings.
				- Conclusion: Include real world example and source link
				3. Content Requirements:
				- Don't hallucinate and just tell real trustworthy facts
				- Include real-world applications or case studies
				- Incorporate relevant statistics or data points when appropriate
				- Explain benefits/implications clearly for non-experts
				4. Tone & Style:
				- Use easy to understand language while maintaining terminology
				5. Response Format:
				- Deliver complete, ready-to-publish answer.
				""";
        String response = chatClient
                .prompt()
                .system(systemPrompt)
                .user(prompt->{
                    prompt.text("Explain me about {topic}");
                    prompt.param("topic",userPrompt);
                })
                .call()
                .content();
        return response;
    }
}
