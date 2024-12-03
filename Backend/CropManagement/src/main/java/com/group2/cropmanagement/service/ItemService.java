package com.group2.cropmanagement.service;


import com.group2.cropmanagement.model.Item;

import java.util.List;

public interface ItemService {

    Item addItem(Item item);

    Item getItem(Long id);

    List<Item> getAllItems();

    List<Item> getItemsByFarmId(Long id);

    Item updateItem(Long id, Item item);

    void deleteItem(Long id);
}
