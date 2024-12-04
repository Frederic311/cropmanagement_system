package com.group2.cropmanagement.repository;

import com.group2.cropmanagement.model.Farm;
import com.group2.cropmanagement.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByFarm(Farm farm);
}
