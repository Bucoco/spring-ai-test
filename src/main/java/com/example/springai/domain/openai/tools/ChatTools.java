package com.example.springai.domain.openai.tools;

import com.example.springai.domain.openai.dto.UserResponseDTO;
import org.springframework.ai.tool.annotation.Tool;

public class ChatTools {
    @Tool(description = "User personal information : name, age, address, phone, etc")
    public UserResponseDTO getUserInfoTool() {
        return new UserResponseDTO("김지훈", 15L, "서울특별시 종로구 청와대로 1", "010-0000-0000", "03048");
    }

}
