package com.group2.cropmanagement.controller;

import com.group2.cropmanagement.dto.HarvestDTO;
import com.group2.cropmanagement.model.Harvest;
import com.group2.cropmanagement.service.HarvestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/harvest")
public class HarvestController {
    @Autowired
    private HarvestService harvestService;

    @PostMapping("/add-harvest")
    public Harvest addHarvest(@RequestBody HarvestDTO harvest) {
        return harvestService.saveHarvest(harvest);
    }

    @GetMapping("/{id}")
    public Harvest getHarvest(@PathVariable Long id){
        return harvestService.getHarvest(id);
    }

    @GetMapping("/all-harvests")
    public List<Harvest> getHarvests(){
        return harvestService.getHarvests();
    }

    @GetMapping("/all-harvests/{id}")
    public List<Harvest> getHarvestsByFarm(@PathVariable Long id){
        return harvestService.getHarvestsByFarmId(id);
    }

    @PutMapping("/update/{id}")
    public Harvest updateHarvest(@PathVariable Long id, @RequestBody HarvestDTO harvest){
        return harvestService.updateHarvest(id, harvest);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteHarvest(@PathVariable Long id){
        harvestService.deleteHarvest(id);
    }
}
