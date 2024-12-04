package com.group2.cropmanagement.service;


import com.group2.cropmanagement.dto.FarmTaskDTO;
import com.group2.cropmanagement.model.FarmTask;

import java.util.List;

public interface FarmTaskService {

    FarmTask createFarmTask(FarmTaskDTO farmTask);

    FarmTask getFarmTask(Long id);

    List<FarmTask> getAllFarmTasks();

    List<FarmTask> getFarmTasksByFarmId(Long id);

    FarmTask updateFarmTask(Long id, FarmTaskDTO farmTask);

    void deleteFarmTask(Long id);


}
