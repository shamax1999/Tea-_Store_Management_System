package edu.icet.service;

import edu.icet.dto.Item;

import java.util.List;

public interface ItemService {
    List<Item> getItem();

    void addItem(Item item);

    void deleteById(Integer itemId);

    List<Item> searchByItemId(Integer itemId);

    List<Item> searchByItemName(String itemName);

    List<Item> searchByTeaType(String teaType);



}
