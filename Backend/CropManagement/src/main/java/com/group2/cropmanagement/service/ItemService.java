package com.group2.cropmanagement.service;

import Group1.Crop_Management.Model.Item;

import java.util.List;

public interface ItemService {

    Item addItem(Item item);

    Item getItem(Long id);

    List<Item> getAllItems();

    List<Item> getItemsByFarmId(Long id);

    Item updateItem(Long id, Item item);

    void deleteItem(Long id);
}
