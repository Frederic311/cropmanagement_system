package com.group2.cropmanagement.controller;

import com.group2.cropmanagement.dto.CropDTO;
import com.group2.cropmanagement.model.Crop;
import com.group2.cropmanagement.service.CropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/crop")
public class CropController {
    @Autowired
    private CropService cropService;

    @PostMapping("/add-crop")
    public Crop addCrop(@RequestBody CropDTO crop){
        return cropService.addCrop(crop);
    }

    @GetMapping("/{id}")
    public Crop getCrop(@PathVariable Long id){
        return cropService.getCrop(id);
    }

    @GetMapping("/all-crops")
    public List<Crop> getAllCrops(){
        return cropService.getAllCrops();
    }

    @GetMapping("/all-crops/{id}")
    public List<Crop> getCropsByFarmId(@PathVariable Long id){

        return cropService.getCropsByFarmId(id);
    }

    @PutMapping("/update/{id}")
    public Crop updateCrop(@PathVariable Long id, @RequestBody CropDTO crop){
        return cropService.updateCrop(id, crop);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCrop(@PathVariable Long id){
        cropService.deleteCrop(id);
    }
}
