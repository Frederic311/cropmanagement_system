package com.group2.cropmanagement.service.impl;

import com.group2.cropmanagement.dto.CropDTO;
import com.group2.cropmanagement.model.Crop;
import com.group2.cropmanagement.model.Farm;
import com.group2.cropmanagement.repository.CropRepository;
import com.group2.cropmanagement.repository.FarmRepository;
import com.group2.cropmanagement.service.CropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CropServiceImpl implements CropService {
    @Autowired
    private FarmRepository farmRepository;
    @Autowired
    private CropRepository cropRepository;

    @Override
    public Crop addCrop(CropDTO crop) {
        Crop newCrop = new Crop();
        newCrop.setCropName(crop.getCropName());
        newCrop.setCropDescription(crop.getCropDescription());
        for(Long farmId : crop.getFarms_id()) {
            Farm farm = farmRepository.findById(farmId).orElse(null);
            List<Farm> farms = newCrop.getFarms();
            farms.add(farm);
            newCrop.setFarms(farms);
        }
        return cropRepository.save(newCrop);
    }

    @Override
    public Crop getCrop(Long id) {
        return cropRepository.findById(id).orElse(null);
    }

    @Override
    public List<Crop> getAllCrops() {
        return cropRepository.findAll();
    }

    @Override
    public List<Crop> getCropsByFarmId(Long id) {
        return cropRepository.findCropByFarm(farmRepository.findById(id).orElse(null));
    }

    @Override
    public Crop updateCrop(Long id, CropDTO crop) {
        Crop cropToUpdate = cropRepository.findById(id).orElse(null);
        if(cropToUpdate != null) {
            cropToUpdate.setCropName(crop.getCropName());
            cropToUpdate.setCropDescription(crop.getCropDescription());
            for(Long farmId : crop.getFarms_id()) {
                Farm farm = farmRepository.findById(farmId).orElse(null);
                List<Farm> farms = cropToUpdate.getFarms();
                farms.add(farm);
                cropToUpdate.setFarms(farms);
            }
            return cropRepository.save(cropToUpdate);
        }
        return null;
    }

    @Override
    public void deleteCrop(Long id) {
        cropRepository.deleteById(id);
    }
}
