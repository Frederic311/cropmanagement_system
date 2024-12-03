package com.group2.cropmanagement.service.impl;

import com.group2.cropmanagement.model.Farm;
import com.group2.cropmanagement.service.FarmService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmServiceImpl implements FarmService {
    @Override
    public Farm addFarm(Farm farm) {
        return null;
    }

    @Override
    public Farm getFarm(Long id) {
        return null;
    }

    @Override
    public List<Farm> getAllFarms() {
        return List.of();
    }

    @Override
    public List<Farm> getFarmsByUserId(Long id) {
        return List.of();
    }

    @Override
    public Farm updateFarm(Long id, Farm farm) {
        return null;
    }

    @Override
    public void deleteFarm(Long id) {

    }
}
