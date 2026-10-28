package com.sakshi.Ai.controller;

import com.sakshi.Ai.dto.ChatRequest;
import com.sakshi.Ai.service.AiService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ai")
public class AiController {

    private final AiService aiService;

    public AiController(AiService aiService) {
        this.aiService = aiService;
    }

    @GetMapping("/ask")
    public String ask(@RequestParam String question) {

        return aiService.ask(question);
    }

    @PostMapping("/chat")
    public String chat(@RequestBody ChatRequest request) {

        return aiService.ask(request.getMessage());
    }
}