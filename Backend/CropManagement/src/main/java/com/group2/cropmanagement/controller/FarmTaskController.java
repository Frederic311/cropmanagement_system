package com.group2.cropmanagement.controller;

import com.group2.cropmanagement.dto.FarmTaskDTO;
import com.group2.cropmanagement.model.FarmTask;
import com.group2.cropmanagement.service.FarmTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/farm-task")
public class FarmTaskController {
    @Autowired
    private FarmTaskService farmTaskService;

    @PostMapping("/add-farm-task")
    public FarmTask addFarmTask(@RequestBody FarmTaskDTO farmTask){
        return farmTaskService.createFarmTask(farmTask);
    }

    @GetMapping("/{id}")
    public FarmTask getFarmTask(@PathVariable Long id){
        return farmTaskService.getFarmTask(id);
    }

    @GetMapping("/all-farm-tasks")
    public List<FarmTask> getAllFarmTasks(){
        return farmTaskService.getAllFarmTasks();
    }

    @GetMapping("/all-farm-tasks/{id}")
    public List<FarmTask> getFarmTasksByFarmId(@PathVariable Long id){
        return farmTaskService.getFarmTasksByFarmId(id);
    }

    @PutMapping("/update/{id}")
    public FarmTask updateFarmTask(@PathVariable Long id, @RequestBody FarmTaskDTO farmTask){
        return farmTaskService.updateFarmTask(id, farmTask);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFarmTask(@PathVariable Long id){
        farmTaskService.deleteFarmTask(id);
    }
}
