package com.group2.cropmanagement.service.impl;

import com.group2.cropmanagement.dto.FarmTaskDTO;
import com.group2.cropmanagement.model.FarmTask;
import com.group2.cropmanagement.repository.FarmRepository;
import com.group2.cropmanagement.repository.FarmTaskRepository;
import com.group2.cropmanagement.service.FarmTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmTaskServiceImpl implements FarmTaskService {
    @Autowired
    private FarmRepository farmRepository;

    @Autowired
    private FarmTaskRepository farmTaskRepository;

    @Override
    public FarmTask createFarmTask(FarmTaskDTO farmTask) {
        FarmTask newFarmTask = new FarmTask();
        newFarmTask.setName(farmTask.getName());
        newFarmTask.setDescription(farmTask.getDescription());
        newFarmTask.setDeadline(farmTask.getDeadline());
        newFarmTask.setIsCompleted(farmTask.getIsCompleted());
        newFarmTask.setFarm(farmRepository.findById(farmTask.getFarmId()).orElse(null));
        return farmTaskRepository.save(newFarmTask);
    }

    @Override
    public FarmTask getFarmTask(Long id) {
        return farmTaskRepository.findById(id).orElse(null);
    }

    @Override
    public List<FarmTask> getAllFarmTasks() {
        return farmTaskRepository.findAll();
    }

    @Override
    public List<FarmTask> getFarmTasksByFarmId(Long id) {
        return farmTaskRepository.findFarmTaskByFarm(farmRepository.findById(id).orElse(null));
    }

    @Override
    public FarmTask updateFarmTask(Long id, FarmTaskDTO farmTask) {
        FarmTask existingFarmTask = farmTaskRepository.findById(id).orElse(null);
        existingFarmTask.setName(farmTask.getName());
        existingFarmTask.setDescription(farmTask.getDescription());
        existingFarmTask.setDeadline(farmTask.getDeadline());
        existingFarmTask.setIsCompleted(farmTask.getIsCompleted());
        existingFarmTask.setFarm(farmRepository.findById(farmTask.getFarmId()).orElse(null));
        return farmTaskRepository.save(existingFarmTask);
    }

    @Override
    public void deleteFarmTask(Long id) {
        farmTaskRepository.deleteById(id);
    }
}
