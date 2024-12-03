package com.group2.cropmanagement.repository;

import Group1.Crop_Management.Model.Farm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmRepository extends JpaRepository<Farm, Long> {
}
