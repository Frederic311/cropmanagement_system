package com.group2.cropmanagement.service.impl;

import com.group2.cropmanagement.dto.ItemDTO;
import com.group2.cropmanagement.model.Farm;
import com.group2.cropmanagement.model.Item;
import com.group2.cropmanagement.repository.FarmRepository;
import com.group2.cropmanagement.repository.ItemRepository;
import com.group2.cropmanagement.service.FarmService;
import com.group2.cropmanagement.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private FarmRepository farmRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item addItem(ItemDTO item) {
        Item newItem = new Item();
        newItem.setName(item.getName());
        newItem.setDescription(item.getDescription());
        newItem.setCategory(item.getCategory());
        newItem.setFarm(farmRepository.findById(item.getFarmId()).orElse(null));
        return itemRepository.save(newItem);
    }

    @Override
    public Item getItem(Long id) {
        return itemRepository.getReferenceById(id);
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public List<Item> getItemsByFarmId(Long id) {
        Farm farm = farmRepository.findById(id).orElse(null);
        return itemRepository.findByFarm(farm);
    }

    @Override
    public Item updateItem(Long id, ItemDTO item) {
        Item existingItem = itemRepository.findById(id).orElse(null);
        if (existingItem != null) {
            existingItem.setName(item.getName());
            existingItem.setDescription(item.getDescription());
            existingItem.setCategory(item.getCategory());
            existingItem.setFarm(farmRepository.findById(item.getFarmId()).orElse(null));
            return itemRepository.save(existingItem);
        }
        return null;
    }

    @Override
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}
