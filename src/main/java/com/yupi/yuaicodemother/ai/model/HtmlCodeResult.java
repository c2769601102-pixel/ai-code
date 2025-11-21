package com.yupi.yuaicodemother.ai.model;

import jdk.jfr.Description;
import lombok.Data;

/**
 * @author cui
 * @version 1.0
 * @description todo
 * @date 2025/11/20下午5:47
 */
@Description("生成 HTML 代码文件的结果")
@Data
public class HtmlCodeResult {

    @Description("HTML代码")
    private String htmlCode;

    @Description("生成代码的描述")
    private String description;
}
