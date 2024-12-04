package com.group2.cropmanagement.repository;

import com.group2.cropmanagement.model.Farm;
import com.group2.cropmanagement.model.Harvest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HarvestRepository extends JpaRepository<Harvest, Long> {
    List<Harvest> findHarvestsByFarm(Farm farm);
}
