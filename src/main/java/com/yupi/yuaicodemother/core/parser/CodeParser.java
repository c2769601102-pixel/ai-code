package com.yupi.yuaicodemother.core.parser;

/**
 * @author cui
 * @version 1.0
 * @description 代码解析器策略接口
 * @date 2025/11/21下午7:15
 */
public interface CodeParser<T> {

    /**
     * 解析代码内容
     * @param codeContent
     * @return
     */
    T parseCode(String codeContent);
}
