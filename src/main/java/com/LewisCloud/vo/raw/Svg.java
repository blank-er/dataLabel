package com.LewisCloud.vo.raw;

import lombok.*;
import lombok.Data;

import java.util.HashMap;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Svg {
    private String uuid;
    private List<HashMap<String, Double>> segmentation;
    private int radius;
    private int subarea;
    private String color;
    private String name;
    private String tool;
    private boolean isCrowd;

}