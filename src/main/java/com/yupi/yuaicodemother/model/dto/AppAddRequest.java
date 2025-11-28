package com.yupi.yuaicodemother.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 创建应用请求
 */
@Data
public class AppAddRequest implements Serializable {

    /**
     * 初始化 prompt
     */
    private String initPrompt;

    private static final long serialVersionUID = 1L;
}

