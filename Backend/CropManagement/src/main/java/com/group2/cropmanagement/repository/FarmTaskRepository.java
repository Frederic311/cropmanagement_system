package com.group2.cropmanagement.repository;

import com.group2.cropmanagement.model.Farm;
import com.group2.cropmanagement.model.FarmTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FarmTaskRepository extends JpaRepository<FarmTask, Long> {
    List<FarmTask> findFarmTaskByFarm(Farm farm);
}
