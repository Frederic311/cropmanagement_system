package com.group2.cropmanagement.repository;

import Group1.Crop_Management.Model.FarmTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmTaskRepository extends JpaRepository<FarmTask, Long> {
}
