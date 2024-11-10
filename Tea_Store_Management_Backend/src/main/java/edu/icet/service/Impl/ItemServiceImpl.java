package edu.icet.service.Impl;

import edu.icet.dto.Item;
import edu.icet.entity.ItemEntity;
import edu.icet.repository.itemRepository;
import edu.icet.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    final itemRepository repository;
    final ModelMapper mapper;

    @Override
    public List<Item> getItem() {
        List<Item> items = new ArrayList<>();
        repository.findAll().forEach(item->{
            items.add(mapper.map(item,Item.class));
        });
        return  items;
    }

    @Override
    public void addItem(Item item) {
        repository.save(mapper.map(item, ItemEntity.class));
    }

    @Override
    public void deleteById(Integer itemId) {
        repository.deleteById(itemId);
    }

    @Override
    public List<Item> searchByItemId(Integer itemId) {
        List<Item> itemList =new ArrayList<>();
        repository.findByItemId(itemId).forEach(entity->{
            itemList.add(mapper.map(entity, Item.class));
        });
        return itemList;
    }

    @Override
    public List<Item> searchByItemName(String itemName) {
        List<Item> itemList =new ArrayList<>();
        repository.findByItemName(itemName).forEach(entity->{
            itemList.add(mapper.map(entity, Item.class));
        });
        return itemList;
    }

    @Override
    public List<Item> searchByTeaType(String teaType) {
        List<Item> itemList =new ArrayList<>();
        repository.findByTeaType(teaType).forEach(entity->{
            itemList.add(mapper.map(entity, Item.class));
        });
        return itemList;
    }



}
