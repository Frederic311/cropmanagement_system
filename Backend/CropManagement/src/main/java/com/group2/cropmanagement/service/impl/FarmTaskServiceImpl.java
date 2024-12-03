package com.group2.cropmanagement.service.impl;

import Group1.Crop_Management.Model.FarmTask;
import Group1.Crop_Management.Service.FarmTaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmTaskServiceImpl implements FarmTaskService {
    @Override
    public FarmTask createFarmTask(FarmTask farmTask) {
        return null;
    }

    @Override
    public FarmTask getFarmTask(Long id) {
        return null;
    }

    @Override
    public List<FarmTask> getAllFarmTasks() {
        return List.of();
    }

    @Override
    public List<FarmTask> getFarmTasksByFarmId(Long id) {
        return List.of();
    }

    @Override
    public FarmTask updateFarmTask(Long id, FarmTask farmTask) {
        return null;
    }

    @Override
    public void deleteFarmTask(Long id) {

    }
}
