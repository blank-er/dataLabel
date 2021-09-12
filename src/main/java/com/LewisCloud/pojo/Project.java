package com.LewisCloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    int workerMaxNum;
    String photosPath;
    String cocoPath;
}
