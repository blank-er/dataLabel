package com.LewisCloud.vo.raw;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Submit {
    private String projectName;
    private String createdAt;
    private com.LewisCloud.vo.raw.Data data;
    private String labelType;
    private String review;

    private String imagePath;
    private int imageWidth;
    private int imageHeight;
    private int imageSize;
    private int imageId;
    private String imageName;
    private int projectId;
}