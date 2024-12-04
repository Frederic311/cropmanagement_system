package com.group2.cropmanagement.service.impl;

import com.group2.cropmanagement.dto.FarmDTO;
import com.group2.cropmanagement.dto.FarmSearchDTO;
import com.group2.cropmanagement.model.Farm;
import com.group2.cropmanagement.model.User;
import com.group2.cropmanagement.repository.FarmRepository;
import com.group2.cropmanagement.repository.UserRepository;
import com.group2.cropmanagement.service.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FarmServiceImpl implements FarmService {
    @Autowired
    private FarmRepository farmRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Farm addFarm(FarmDTO farm) {
        Farm newFarm = new Farm();
        newFarm.setName(farm.getName());
        newFarm.setDescription(farm.getDescription());
        newFarm.setUser(userRepository.findById(farm.getUserId()).orElse(null) );
        return farmRepository.save(newFarm);
    }

    @Override
    public Farm getFarm(Long id) {
        return farmRepository.findById(id).orElse(null);
    }

    @Override
    public List<Farm> getAllFarms() {
        return farmRepository.findAll();
    }

    @Override
    public List<FarmSearchDTO> getFarmsByUserId(Long id) {
        User user = userRepository.findById(id).orElse(null);
        List<Farm> farms = farmRepository.findFarmByUser(user);
        List<FarmSearchDTO> farmSearchDTOS = new ArrayList<FarmSearchDTO>();

        for(Farm farm : farms){
            FarmSearchDTO farmSearchDTO = new FarmSearchDTO();
            farmSearchDTO.setId(farm.getId());
            farmSearchDTO.setName(farm.getName());
            farmSearchDTO.setDescription(farm.getDescription());
            farmSearchDTOS.add(farmSearchDTO);
        }

        return farmSearchDTOS;
    }

    @Override
    public Farm updateFarm(Long id, FarmDTO farm) {
        Farm existingFarm = farmRepository.findById(id).orElse(null);
        if (existingFarm != null) {
            existingFarm.setName(farm.getName());
            existingFarm.setDescription(farm.getDescription());
            return farmRepository.save(existingFarm);
        }
        return null;
    }

    @Override
    public void deleteFarm(Long id) {
        farmRepository.deleteById(id);
    }


}
