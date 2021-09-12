package com.LewisCloud.common.core.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//新建项目映射视图
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProject {
    String title;
    String introduction;
    int workerMaxNum;
}
