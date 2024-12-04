package com.group2.cropmanagement.service;


import com.group2.cropmanagement.dto.ItemDTO;
import com.group2.cropmanagement.model.Item;

import java.util.List;

public interface ItemService {

    Item addItem(ItemDTO item);

    Item getItem(Long id);

    List<Item> getAllItems();

    List<Item> getItemsByFarmId(Long id);

    Item updateItem(Long id, ItemDTO item);

    void deleteItem(Long id);
}
