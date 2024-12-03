package com.group2.cropmanagement.service.impl;

import com.group2.cropmanagement.model.Crop;
import com.group2.cropmanagement.service.CropService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CropServiceImpl implements CropService {
    @Override
    public Crop addCrop(Crop crop) {
        return null;
    }

    @Override
    public Crop getCrop(Long id) {
        return null;
    }

    @Override
    public List<Crop> getAllCrops() {
        return List.of();
    }

    @Override
    public List<Crop> getCropsByFarmId(Long id) {
        return List.of();
    }

    @Override
    public Crop updateCrop(Long id, Crop crop) {
        return null;
    }

    @Override
    public void deleteCrop(Long id) {

    }
}
