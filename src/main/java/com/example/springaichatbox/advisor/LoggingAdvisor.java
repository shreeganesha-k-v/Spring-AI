package com.example.springaichatbox.advisor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClientRequest;
import org.springframework.ai.chat.client.ChatClientResponse;
import org.springframework.ai.chat.client.advisor.api.CallAdvisor;
import org.springframework.ai.chat.client.advisor.api.CallAdvisorChain;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LoggingAdvisor implements CallAdvisor {
    @Override
    public ChatClientResponse adviseCall(ChatClientRequest chatClientRequest, CallAdvisorChain callAdvisorChain) {
        logRequest(chatClientRequest);
        ChatClientResponse response = callAdvisorChain.nextCall(chatClientRequest);
        logResponse(response);
        return response;
    }

    @Override
    public String getName() {
        return "loggingAdvisor";
    }

    @Override
    public int getOrder() {
        return 0;
    }

    private void logRequest(ChatClientRequest request) {
        log.info("Request: {}", request);
    }

    private void logResponse(ChatClientResponse response) {
        log.info("Response: {}", response);
    }
}
