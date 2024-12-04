package com.group2.cropmanagement.controller;

import com.group2.cropmanagement.dto.FarmDTO;
import com.group2.cropmanagement.dto.FarmSearchDTO;
import com.group2.cropmanagement.model.Farm;
import com.group2.cropmanagement.service.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/farm")
public class FarmController {
    @Autowired
    private FarmService farmService;

    @PostMapping("/add-farm")
    public Farm addFarm(@RequestBody FarmDTO farm) {
        return farmService.addFarm(farm);
    }

    @GetMapping("/all-farms")
    public List<Farm> getAllFarms() {
        return farmService.getAllFarms();
    }

    @GetMapping("/all-farms/{id}")
    public List<FarmSearchDTO> getAllFarms(@PathVariable Long id) {
        return farmService.getFarmsByUserId(id);
    }

    @GetMapping("/{id}")
    public Farm getFarm(@PathVariable Long id) {
        return farmService.getFarm(id);
    }

    @PutMapping("/update/{id}")
    public Farm updateFarm(@PathVariable Long id, @RequestBody FarmDTO farm) {
        return farmService.updateFarm(id, farm);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFarm(@PathVariable Long id) {
        farmService.deleteFarm(id);
    }

}
