package com.group2.cropmanagement.service.impl;

import com.group2.cropmanagement.dto.HarvestDTO;
import com.group2.cropmanagement.model.Crop;
import com.group2.cropmanagement.model.Harvest;
import com.group2.cropmanagement.repository.CropRepository;
import com.group2.cropmanagement.repository.FarmRepository;
import com.group2.cropmanagement.repository.HarvestRepository;
import com.group2.cropmanagement.service.HarvestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HarvestServiceImpl implements HarvestService {
    @Autowired
    private HarvestRepository harvestRepository;

    @Autowired
    private FarmRepository farmRepository;

    @Autowired
    private CropRepository cropRepository;

    @Override
    public Harvest saveHarvest(HarvestDTO harvest) {
        Harvest newHarvest = new Harvest();
        newHarvest.setTitle(harvest.getTitle());
        newHarvest.setHarvestDate(harvest.getHarvestDate());
        newHarvest.setQuantity(harvest.getQuantity());
        newHarvest.setFarm(farmRepository.findById(harvest.getFarmId()).orElse(null));
        newHarvest.setCrop(cropRepository.findById(harvest.getCropId()).orElse(null));
        return harvestRepository.save(newHarvest);
    }

    @Override
    public Harvest getHarvest(Long id) {
        return harvestRepository.findById(id).orElse(null);
    }

    @Override
    public List<Harvest> getHarvests() {
        return harvestRepository.findAll();
    }

    @Override
    public List<Harvest> getHarvestsByFarmId(Long id) {
        return harvestRepository.findHarvestsByFarm(farmRepository.findById(id).orElse(null));
    }

    @Override
    public Harvest updateHarvest(Long id, HarvestDTO harvest) {
        Harvest existingHarvest = harvestRepository.findById(id).orElse(null);
        if(existingHarvest != null) {
            existingHarvest.setHarvestDate(harvest.getHarvestDate());
            existingHarvest.setTitle(harvest.getTitle());
            existingHarvest.setQuantity(harvest.getQuantity());
            existingHarvest.setFarm(farmRepository.findById(harvest.getFarmId()).orElse(null));
            existingHarvest.setCrop(cropRepository.findById(harvest.getCropId()).orElse(null));

            return harvestRepository.save(existingHarvest);
        }
        return null;
    }

    @Override
    public void deleteHarvest(Long id) {
        harvestRepository.deleteById(id);
    }


}
