package com.LewisCloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/* state: 0未进行标注 1标注中 2已进行标注*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Photo {
    private int id;
    private int projectId;
    private int state;
    private int height;
    private int width;
    private String name;
    private String type;
    private String path;
}
