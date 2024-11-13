package edu.icet.service.Impl;

import edu.icet.dto.Item;
import edu.icet.entity.ItemEntity;
import edu.icet.repository.itemRepository;
import edu.icet.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    final itemRepository repository;
    final ModelMapper mapper;

    @Override
    public List<Item> getItem() {
        List<Item> items = new ArrayList<>();
        repository.findAll().forEach(itemEntity -> {
            Item item = mapper.map(itemEntity, Item.class);
            if (itemEntity.getImageData() != null) {
                item.setImageData(Base64.getEncoder().encodeToString(itemEntity.getImageData()).getBytes());
            }
            items.add(item);
        });
        return items;
    }

    @Override
    public void addItem(Item item, MultipartFile image) throws IOException {
        ItemEntity itemEntity = mapper.map(item, ItemEntity.class);

        // Handle image as byte[] directly
        if (image != null && !image.isEmpty()) {
            itemEntity.setImageData(image.getBytes()); // Store image bytes directly
        }

        // Save the item entity to the repository
        repository.save(itemEntity);
    }


    @Override
    public void updateItem(Item item, MultipartFile image) throws IOException {
        ItemEntity itemEntity = repository.findById(item.getItemId()).orElseThrow(() -> new RuntimeException("Item not found"));
        mapper.map(item, itemEntity); // Update fields in existing entity
        if (image != null && !image.isEmpty()) {
            itemEntity.setImageData(Base64.getEncoder().encodeToString(item.getImageData()).getBytes());
        }
        repository.save(itemEntity);
    }

    @Override
    public void deleteById(Integer itemId) {
        repository.deleteById(itemId);
    }

    @Override
    public List<Item> searchByItemId(Integer itemId) {
        List<Item> itemList = new ArrayList<>();
        repository.findByItemId(itemId).forEach(entity -> {
            Item item = mapper.map(entity, Item.class);
            if (entity.getImageData() != null) {
                item.setImageData(Base64.getEncoder().encodeToString(entity.getImageData()).getBytes());
            }
            itemList.add(item);
        });
        return itemList;
    }

    @Override
    public List<Item> searchByItemName(String itemName) {
        List<Item> itemList = new ArrayList<>();
        repository.findByItemName(itemName).forEach(entity -> {
            Item item = mapper.map(entity, Item.class);
            if (entity.getImageData() != null) {
                item.setImageData(Base64.getEncoder().encodeToString(entity.getImageData()).getBytes());
            }
            itemList.add(item);
        });
        return itemList;
    }

    @Override
    public List<Item> searchByTeaType(String teaType) {
        List<Item> itemList = new ArrayList<>();
        repository.findByTeaType(teaType).forEach(entity -> {
            Item item = mapper.map(entity, Item.class);
            if (entity.getImageData() != null) {
                item.setImageData(Base64.getEncoder().encodeToString(entity.getImageData()).getBytes());
            }
            itemList.add(item);
        });
        return itemList;
    }



}