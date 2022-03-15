package com.LewisCloud.service;

public interface PathService {
    String getOriginalPath();
    String allocatePath();
    String getPhotosPath(int projectId);
    String getCocoPath(int projectId);
}
