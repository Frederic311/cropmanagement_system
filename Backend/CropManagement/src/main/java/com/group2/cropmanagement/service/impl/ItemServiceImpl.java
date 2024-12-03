package com.group2.cropmanagement.service.impl;

import Group1.Crop_Management.Model.Item;
import Group1.Crop_Management.Service.ItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Override
    public Item addItem(Item item) {
        return null;
    }

    @Override
    public Item getItem(Long id) {
        return null;
    }

    @Override
    public List<Item> getAllItems() {
        return List.of();
    }

    @Override
    public List<Item> getItemsByFarmId(Long id) {
        return List.of();
    }

    @Override
    public Item updateItem(Long id, Item item) {
        return null;
    }

    @Override
    public void deleteItem(Long id) {

    }
}
