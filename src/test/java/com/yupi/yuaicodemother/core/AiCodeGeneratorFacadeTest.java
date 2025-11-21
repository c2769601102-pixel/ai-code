package com.yupi.yuaicodemother.core;

import com.yupi.yuaicodemother.model.enums.CodeGenTypeEnum;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AiCodeGeneratorFacadeTest {

    @Resource
    AiCodeGeneratorFacade aiCodeGeneratorFacade;

    @Test
    void generateAndSaveCode() {
        File file = aiCodeGeneratorFacade.generateAndSaveCode("做个程序员鱼皮的工作记录小工具,20行内代码", CodeGenTypeEnum.HTML);
        Assertions.assertNotNull(file);
    }

    @Test
    void generateAndSaveMultiCode() {
        File file = aiCodeGeneratorFacade.generateAndSaveCode("做个程序员cui的日记记录小工具,30行内代码", CodeGenTypeEnum.MULTI_FILE);
        Assertions.assertNotNull(file);
    }

    @Test
    void generateAndSaveCodeStream() {
        Flux<String> codestream = aiCodeGeneratorFacade.generateAndSaveCodeStream("做个程序员cui的emo日记，不超过20行", CodeGenTypeEnum.HTML);
        // 阻塞等待所有数据收集完成
        List<String> result = codestream.collectList().block();
        // 验证结果
        Assertions.assertNotNull(result);
        String completeContent = String.join("", result);
        Assertions.assertNotNull(completeContent);
    }

    @Test
    void generateAndSaveCodeStream1() {
        Flux<String> codestream = aiCodeGeneratorFacade.generateAndSaveCodeStream("做个程序员cui的enjoy日记，不超过20行", CodeGenTypeEnum.MULTI_FILE);
        // 阻塞等待所有数据收集完成
        List<String> result = codestream.collectList().block();
        // 验证结果
        Assertions.assertNotNull(result);
        String completeContent = String.join("", result);
        Assertions.assertNotNull(completeContent);
    }

    @Test
    void testGenerateAndSaveCode() {
        File file = aiCodeGeneratorFacade.generateAndSaveCode("做个程序员cui的enjoy日记，不超过20行",
                CodeGenTypeEnum.MULTI_FILE);
        assertNotNull(file);
    }

    @Test
    void testGenerateAndSaveCodeStream() {
        Flux<String> codeStream = aiCodeGeneratorFacade.generateAndSaveCodeStream("做个程序员cui的enjoy日记，不超过20行",
                CodeGenTypeEnum.MULTI_FILE);
        List<String> result = codeStream.collectList().block();
        assertNotNull(result);
    }
}