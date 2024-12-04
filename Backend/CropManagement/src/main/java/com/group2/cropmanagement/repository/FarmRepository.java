package com.group2.cropmanagement.repository;

import com.group2.cropmanagement.model.Farm;
import com.group2.cropmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FarmRepository extends JpaRepository<Farm, Long> {
    List<Farm> findFarmByUser(User user);
}
