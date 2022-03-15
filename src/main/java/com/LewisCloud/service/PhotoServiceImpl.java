package com.LewisCloud.service;

import com.LewisCloud.common.exception.BaseException;
import com.LewisCloud.mapper.PhotoMapper;
import com.LewisCloud.pojo.Photo;
import com.LewisCloud.pojo.Project;
import com.LewisCloud.service.label.ImageProcessService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service("photoService")
public class PhotoServiceImpl implements PhotoService {
    @Autowired
    private PhotoMapper photoMapper;

    @Autowired
    private ProjectService projectService;

    @Override
    public boolean uploadPhoto(HttpServletRequest request) {
        System.out.println("进入upload");

        //上传图片对应的项目id
        int projectId = -1;
        //项目信息
        Project project = null;
        //上传文件名
        String uploadFileName = null;
        //上传文件后缀
        String fileExtName = null;
        //上传到的路径
        String filePath = null;
        //随机不重复的uuid名
        String uuidName = null;
        //最终储存在文件系统中的名字
        String storeFileName = null;

        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload();
        File image = null;

        try {
            List<FileItem> fileItemList = servletFileUpload.parseRequest(request);
            for (FileItem fileItem : fileItemList) {
                if (fileItem.isFormField()) {
                    if (Objects.equals(fileItem.getFieldName(), "projectId")) {
                        projectId = Integer.parseInt(fileItem.getString("UTF-8"));
                        System.out.println(projectId);
                        project = projectService.getProjectById(projectId);
                        if (project == null) {
                            return false;
                        }
                        filePath = project.getPhotosPath();
                        diskFileItemFactory.setRepository(new File(String.valueOf(filePath)));
                        servletFileUpload.setFileItemFactory(diskFileItemFactory);
                    }
                } else {
                    if (project == null) {
                        return false;
                    }
                    uploadFileName = fileItem.getName();
                    System.out.println("上传的文件名" + uploadFileName);
                    if (uploadFileName == null || uploadFileName.trim().equals("")) { // 文件名为空值或空
                        continue; // 进入下一轮循环，判断下一个FileItem对象
                    }
                    fileExtName = uploadFileName.substring(uploadFileName.lastIndexOf(".") + 1);
                    System.out.println("文件信息【文件名：" + uploadFileName + "，文件类型：" + fileExtName + "】");
                    uuidName = UUID.randomUUID().toString();
                    storeFileName = uuidName + "." + fileExtName;

//                    InputStream inputStream = fileItem.getInputStream();
//                    FileOutputStream fileOutputStream = new FileOutputStream();
                    image = new File(filePath, storeFileName);
                    fileItem.write(image);
                }
            }
            photoMapper.addPhoto(new Photo(0, project.getId(), 0, ImageProcessService.getHeight(image),
                    ImageProcessService.getWidth(image) ,uuidName, fileExtName, filePath + "\\" + storeFileName));
        } catch (Exception e) {
            throw new BaseException(e.getMessage());
        }
        return true;
    }
}

