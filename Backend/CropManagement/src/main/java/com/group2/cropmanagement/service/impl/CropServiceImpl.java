package com.group2.cropmanagement.service.impl;

import Group1.Crop_Management.Model.Crop;
import Group1.Crop_Management.Service.CropService;
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
