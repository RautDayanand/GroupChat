package com.example.websocket_demo.service;

import com.example.websocket_demo.model.ChatMessage;
import com.example.websocket_demo.repo.ChatMessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImplementation implements ChatService {

    @Autowired
    private ChatMessageRepo repo;

    @Override
    public ChatMessage saveMessages(ChatMessage msg){
        return repo.save(msg);
    }

    @Override
    public List<ChatMessage> getChatHistory(String user1, String user2){
        return repo.findBySenderNameAndReceiverNameOrReceiverNameAndSenderNameOrderByTime(user1,user2,user1,user2);
    }
}
