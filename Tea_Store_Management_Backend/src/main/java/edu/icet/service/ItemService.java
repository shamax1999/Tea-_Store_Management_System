package edu.icet.service;

import edu.icet.dto.Item;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ItemService {
    List<Item> getItem();

    void addItem(Item item, MultipartFile image) throws IOException;

    void deleteById(Integer itemId);

    List<Item> searchByItemId(Integer itemId);

    List<Item> searchByItemName(String itemName);

    List<Item> searchByTeaType(String teaType);

    void updateItem(Item item, MultipartFile image) throws IOException;

    ResponseEntity<byte[]> getItemImageById(Integer itemId);
}
