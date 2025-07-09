package com.example.springai.domain.openai.service;

import com.example.springai.domain.openai.entity.ChatEntity;
import com.example.springai.domain.openai.repository.ChatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ChatService {

    private final ChatRepository chatRepository;

    @Transactional(readOnly = true)
    public List<ChatEntity> readAllChats(String userId) {
        return chatRepository.findByUserIdOrderByCreatedAtAsc(userId);
    }
}
