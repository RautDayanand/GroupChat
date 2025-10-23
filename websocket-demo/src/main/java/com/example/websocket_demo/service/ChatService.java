package com.example.websocket_demo.service;

import com.example.websocket_demo.model.ChatMessage;
import com.example.websocket_demo.repo.ChatMessageRepo;

import java.util.List;

public interface ChatService {


    public ChatMessage saveMessages(ChatMessage msg);

    public List<ChatMessage> getChatHistory(String user1, String user2);


}
