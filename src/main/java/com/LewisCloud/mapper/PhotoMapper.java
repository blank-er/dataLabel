package com.LewisCloud.mapper;

import com.LewisCloud.pojo.Photo;

import java.util.List;

public interface PhotoMapper {
    void addPhoto(Photo photo);
    Photo getPhotoById(int id);
    List<Photo> getPhotosByProjectId(int projectId);
}
