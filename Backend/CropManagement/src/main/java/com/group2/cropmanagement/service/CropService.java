package com.group2.cropmanagement.service;

import Group1.Crop_Management.Model.Crop;

import java.util.List;

public interface CropService {

    Crop addCrop(Crop crop);

    Crop getCrop(Long id);

    List<Crop> getAllCrops();

    List<Crop> getCropsByFarmId(Long id);

    Crop updateCrop(Long id, Crop crop);

    void deleteCrop(Long id);
}
