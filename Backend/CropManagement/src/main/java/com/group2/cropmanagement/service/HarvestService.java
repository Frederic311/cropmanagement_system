package com.group2.cropmanagement.service;

import com.group2.cropmanagement.dto.HarvestDTO;
import com.group2.cropmanagement.model.Harvest;

import java.util.List;

public interface HarvestService {
    Harvest saveHarvest(HarvestDTO harvest);

    Harvest getHarvest(Long id);

    List<Harvest> getHarvests();

    List<Harvest> getHarvestsByFarmId(Long id);

    Harvest updateHarvest(Long id, HarvestDTO harvest);

    void deleteHarvest(Long id);
}
