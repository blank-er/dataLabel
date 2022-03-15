package com.LewisCloud.vo.coco;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Annotation {
    private List<List<Double>> segmentation;
    private double area;
    private int iscrowd;
    private int image_id;
    private int category_id;
    private int id;
}
