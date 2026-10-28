package com.sakshi.Ai.dto;

import jakarta.validation.constraints.NotBlank;

public class DocumentRequest {

    @NotBlank(message = "Document content cannot be empty")
    private String content;

    public DocumentRequest() {
    }


    
    public DocumentRequest(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}