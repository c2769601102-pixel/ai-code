package com.yupi.yuaicodemother.core.saver;

import cn.hutool.core.util.StrUtil;
import com.yupi.yuaicodemother.ai.model.HtmlCodeResult;
import com.yupi.yuaicodemother.ai.model.MultiFileCodeResult;
import com.yupi.yuaicodemother.exception.BusinessException;
import com.yupi.yuaicodemother.exception.ErrorCode;
import com.yupi.yuaicodemother.model.enums.CodeGenTypeEnum;
import org.springframework.stereotype.Service;

/**
 * @author cui
 * @version 1.0
 * @description todo
 * @date 2025/11/21下午7:55
 */
@Service
public class MultiFileCodeFileSaverTemplate extends CodeFileSaverTemplate<MultiFileCodeResult> {
    @Override
    protected void saveFiles(MultiFileCodeResult result, String baseDirName) {
        writeToFile(baseDirName, "index.html", result.getHtmlCode());
        writeToFile(baseDirName, "style.css", result.getCssCode());
        writeToFile(baseDirName, "script.js", result.getJsCode());
    }

    @Override
    protected CodeGenTypeEnum getCodeTpe() {
        return CodeGenTypeEnum.HTML;
    }

    @Override
    protected void validateInput(MultiFileCodeResult result) {
        super.validateInput(result);
        // 至少要有 HTML 代码，css 和 js 可为空
        if (StrUtil.isBlank(result.getHtmlCode())) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "HTML代码内容不能为空");
        }
    }
}
