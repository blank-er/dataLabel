package com.LewisCloud.vo.coco;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    private String supercategory;
    private int id;
    private String name;
}
