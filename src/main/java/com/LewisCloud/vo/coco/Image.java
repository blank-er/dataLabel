package com.LewisCloud.vo.coco;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Image {
    private int license;
    private String file_name;
    private String coco_url;
    private int height;
    private int width;
    private int id;
}
