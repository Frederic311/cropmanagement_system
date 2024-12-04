package com.group2.cropmanagement.service;


import com.group2.cropmanagement.dto.CropDTO;
import com.group2.cropmanagement.model.Crop;

import java.util.List;

public interface CropService {

    Crop addCrop(CropDTO crop);

    Crop getCrop(Long id);

    List<Crop> getAllCrops();

    List<Crop> getCropsByFarmId(Long id);

    Crop updateCrop(Long id, CropDTO crop);

    void deleteCrop(Long id);
}
