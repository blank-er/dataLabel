package com.LewisCloud.pojo;

import com.alibaba.fastjson.JSONArray;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/* state: 0未创建  1创建并发布  2进行中  3已完成*/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    int id;
    User manager;
    List<User> worker;
    String state;
    String title;
    String introduction;
    int workerNum;
    int workerMaxNum;
    String photosPath;
    String cocoPath;
}
