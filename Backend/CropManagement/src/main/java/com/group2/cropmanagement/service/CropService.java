package com.group2.cropmanagement.service;


import com.group2.cropmanagement.model.Crop;

import java.util.List;

public interface CropService {

    Crop addCrop(Crop crop);

    Crop getCrop(Long id);

    List<Crop> getAllCrops();

    List<Crop> getCropsByFarmId(Long id);

    Crop updateCrop(Long id, Crop crop);

    void deleteCrop(Long id);
}
