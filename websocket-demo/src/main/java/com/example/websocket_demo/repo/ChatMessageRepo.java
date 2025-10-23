package com.example.websocket_demo.repo;

import com.example.websocket_demo.model.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatMessageRepo extends JpaRepository<ChatMessage,Long> {

    List<ChatMessage> findBySenderNameAndReceiverNameOrReceiverNameAndSenderNameOrderByTime(
            String sender, String receiver, String receiver2, String sender2);

}
