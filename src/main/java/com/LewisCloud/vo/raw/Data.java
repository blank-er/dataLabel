package com.LewisCloud.vo.raw;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class Data {
    private List<Svg> svgArr;
    private List<Classification> classifications;
}