package com.group2.cropmanagement.service;


import com.group2.cropmanagement.model.Farm;

import java.util.List;

public interface FarmService {

    Farm addFarm(Farm farm);

    Farm getFarm(Long id);

    List<Farm> getAllFarms();

    List<Farm> getFarmsByUserId(Long id);

    Farm updateFarm(Long id, Farm farm);

    void deleteFarm(Long id);
}
