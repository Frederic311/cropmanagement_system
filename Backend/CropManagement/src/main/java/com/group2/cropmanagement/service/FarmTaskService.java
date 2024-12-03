package com.group2.cropmanagement.service;


import com.group2.cropmanagement.model.FarmTask;

import java.util.List;

public interface FarmTaskService {

    FarmTask createFarmTask(FarmTask farmTask);

    FarmTask getFarmTask(Long id);

    List<FarmTask> getAllFarmTasks();

    List<FarmTask> getFarmTasksByFarmId(Long id);

    FarmTask updateFarmTask(Long id, FarmTask farmTask);

    void deleteFarmTask(Long id);


}
