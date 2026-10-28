package com.sakshi.Ai.controller;

import com.sakshi.Ai.dto.ChatRequest;
import com.sakshi.Ai.dto.ChatResponse;
import com.sakshi.Ai.service.ChatService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping
    public ResponseEntity<ChatResponse> chat(
            @Valid @RequestBody ChatRequest request) {

        String response = chatService.chat(request.getMessage());

        return ResponseEntity.ok(
                new ChatResponse(response)
        );
    }

    @PostMapping("/rag")
    public ResponseEntity<ChatResponse> ragChat(
            @Valid @RequestBody ChatRequest request) {

        String response = chatService.ragChat(request.getMessage());

        return ResponseEntity.ok(
                new ChatResponse(response)
        );
    }
}