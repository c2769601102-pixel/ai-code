package com.yupi.yuaicodemother.core;

import com.yupi.yuaicodemother.model.enums.CodeGenTypeEnum;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

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
}