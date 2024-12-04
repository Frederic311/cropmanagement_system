package com.group2.cropmanagement.controller;

import com.group2.cropmanagement.dto.ItemDTO;
import com.group2.cropmanagement.model.Item;
import com.group2.cropmanagement.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping("/add-item")
    public Item addItem(@RequestBody ItemDTO item) {
        return itemService.addItem(item);
    }

    @GetMapping("/{id}")
    public Item getItem(@PathVariable Long id) {
        return itemService.getItem(id);
    }

    @GetMapping("/all-items")
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/all-items/{id}")
    public List<Item> getItemsByFarmId(@PathVariable Long id) {
        return itemService.getItemsByFarmId(id);
    }

    @PutMapping("/update/{id}")
    public Item updateItem(@PathVariable Long id, @RequestBody ItemDTO item) {
        return itemService.updateItem(id, item);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
    }
}
