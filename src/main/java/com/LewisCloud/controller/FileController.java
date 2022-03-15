package com.LewisCloud.controller;

import com.LewisCloud.common.core.domain.AjaxResult;
import com.LewisCloud.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class FileController {
    @Autowired
    private PhotoService photoService;

    @PostMapping("/upload")
    public AjaxResult upload(HttpServletRequest httpServletRequest) {
        boolean isUpload = photoService.uploadPhoto(httpServletRequest);
        if (isUpload) {
            return AjaxResult.success("上传成功");
        }else {
            return AjaxResult.error("上传失败");
        }
    }
}
