package com.example.websocket_demo.handler;

import com.example.websocket_demo.model.ChatMessage;
import com.example.websocket_demo.service.ChatServiceImplementation;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
public class MyWebSocketHandler extends TextWebSocketHandler {

    @Autowired
    private ChatServiceImplementation chatService;


    private Set<WebSocketSession> sessions = new CopyOnWriteArraySet<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);
        // Send JSON instead of plain text
        String jsonMsg = "{\"user\":\"server\", \"message\":\"Welcome client 👋\"}";
        session.sendMessage(new TextMessage(jsonMsg));
    }


    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("📩 Message received: " + message.getPayload());
        String payload = message.getPayload();

        // Parse JSON message
        ObjectMapper mapper = new ObjectMapper();
        ChatMessage chatMsg = mapper.readValue(payload, ChatMessage.class);

        // Save to DB
        chatService.saveMessages(chatMsg);

        // Broadcast to all sessions
        for (WebSocketSession s : sessions) {
            if (s.isOpen()) {
                s.sendMessage(new TextMessage(payload));
            }
        }
    }


    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.remove(session);
        System.out.println("❌ Connection closed: " + session.getId());
    }
}
