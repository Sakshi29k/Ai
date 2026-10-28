package com.sakshi.Ai.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private final ChatClient chatClient;

    public ChatService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    public String chat(String message) {

        return chatClient
                .prompt()
                .user(message)
                .call()
                .content();
    }

    public String ragChat(String message) {

        return chatClient
                .prompt()
                .system("""
                        You are a helpful AI assistant.
                        Answer the user's question clearly and accurately.
                        If you do not know the answer, say that you do not know.
                        """)
                .user(message)
                .call()
                .content();
    }
}