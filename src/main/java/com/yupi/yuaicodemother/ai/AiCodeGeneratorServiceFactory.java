package com.yupi.yuaicodemother.ai;

import cn.hutool.ai.core.AIService;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.service.AiServices;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author cui
 * @version 1.0
 * @description todo
 * @date 2025/11/20上午11:53
 */
@Configuration
public class AiCodeGeneratorServiceFactory {

//    @Resource
//    private ChatModel chatModel;

    @Bean
    public AiCodeGeneratorService aiCodeGeneratorService(ChatModel chatModel) {
        return AiServices.create(AiCodeGeneratorService.class, chatModel);
    }
}

