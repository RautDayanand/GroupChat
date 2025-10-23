package com.example.websocket_demo.controller;

import com.example.websocket_demo.model.ChatMessage;
import com.example.websocket_demo.service.ChatServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/chat")
@CrossOrigin(origins = "http://localhost:5173") // React dev server
public class ChatController {
    @Autowired
    private ChatServiceImplementation service;

    @GetMapping("/history")
    public List<ChatMessage> getHistory(@RequestParam String user1, @RequestParam String user2) {
        return service.getChatHistory(user1, user2);
    }
}
