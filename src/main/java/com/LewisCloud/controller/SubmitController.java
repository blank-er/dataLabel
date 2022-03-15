package com.LewisCloud.controller;

import com.LewisCloud.common.core.domain.AjaxResult;
import com.LewisCloud.common.exception.BaseException;
import com.LewisCloud.service.label.SubmitProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubmitController {
    @Autowired
    private SubmitProcessService submitProcessService;

    @PostMapping("/submit")
    public AjaxResult submit(@RequestBody String submitJson) {
        try {
            submitProcessService.getSubmit(submitJson);
            return AjaxResult.success("提交标注成功");
        }catch (Exception e) {
            throw new BaseException("提交标注失败");
        }
    }

}
