package com.example.springai.api;

import com.example.springai.domain.openai.dto.CityResponseDTO;
import com.example.springai.domain.openai.entity.ChatEntity;
import com.example.springai.domain.openai.service.ChatService;
import com.example.springai.domain.openai.service.OpenAiService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Map;

@Controller
public class ChatController {
    private final OpenAiService openAIService;
    private final ChatService chatService;

    public ChatController(OpenAiService openAIService, ChatService chatService) {
        this.openAIService = openAIService;
        this.chatService = chatService;
    }

    @ResponseBody
    @PostMapping("/chat")
    public CityResponseDTO chat(@RequestBody Map<String, String> body) {
        return openAIService.generate(body.get("text"));
    }

    @ResponseBody
    @PostMapping("/chat/stream")
    public Flux<String> streamChat(@RequestBody Map<String, String> body) {
        return openAIService.generateStream(body.get("text"));
    }

    @GetMapping("/")
    public String chatPage() {
        return "chat";
    }

    @ResponseBody
    @PostMapping("/chat/history/{userid}")
    public List<ChatEntity> getChatHistory(@PathVariable("userid") String userId) {
        return chatService.readAllChats(userId);
    }
}
