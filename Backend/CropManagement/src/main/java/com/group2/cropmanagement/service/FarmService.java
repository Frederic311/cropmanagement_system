package com.group2.cropmanagement.service;


import com.group2.cropmanagement.dto.FarmDTO;
import com.group2.cropmanagement.dto.FarmSearchDTO;
import com.group2.cropmanagement.model.Farm;

import java.util.List;

public interface FarmService {

    Farm addFarm(FarmDTO farm);

    Farm getFarm(Long id);

    List<Farm> getAllFarms();

    List<FarmSearchDTO> getFarmsByUserId(Long id);

    Farm updateFarm(Long id, FarmDTO farm);

    void deleteFarm(Long id);
}
