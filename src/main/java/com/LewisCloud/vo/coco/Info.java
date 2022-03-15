package com.LewisCloud.vo.coco;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Info {
    private String description;
    private String url;
    private String version;
    private int year;
    private String contributor;
    private String date_created;
}
