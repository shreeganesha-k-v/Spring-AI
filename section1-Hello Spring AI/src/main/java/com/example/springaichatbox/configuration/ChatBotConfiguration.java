package com.example.springaichatbox.configuration;

import com.example.springaichatbox.advisor.LoggingAdvisor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatBotConfiguration {

    @Bean
    public ChatClient chatClient(ChatClient.Builder chatClientBuilder,
                                 LoggingAdvisor loggingAdvisor,
                                 MessageChatMemoryAdvisor messageChatMemoryAdvisor){
        return chatClientBuilder
                .defaultAdvisors(loggingAdvisor)
                .defaultAdvisors(messageChatMemoryAdvisor)
                .build();
    }

    @Bean
    public MessageChatMemoryAdvisor messageChatMemoryAdvisor(ChatMemory memory) {
        return MessageChatMemoryAdvisor.builder(memory).build();
    }
}
