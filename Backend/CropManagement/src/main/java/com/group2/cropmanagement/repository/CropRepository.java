package com.group2.cropmanagement.repository;

import com.group2.cropmanagement.model.Crop;
import com.group2.cropmanagement.model.Farm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CropRepository extends JpaRepository<Crop, Long> {
    List<Crop> findCropsByFarm(Farm farm);
}
