package edu.icet.controller;

import edu.icet.dto.Item;
import edu.icet.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/item")
@CrossOrigin
public class ItemController {
    final ItemService itemService;

    // Get all items
    @GetMapping("/get-all")
    public List<Item> getAllItems() {
        return itemService.getItem();
    }

    // Add a new item
    @PostMapping("/add-item")
    @ResponseStatus(HttpStatus.CREATED)
    public void addItem(@RequestPart("item") Item item, @RequestPart("image") MultipartFile imageData) throws IOException {
        itemService.addItem(item, imageData);
    }

    // Update an existing item
    @PutMapping("/update-item/{itemId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateItem(@PathVariable Integer itemId, @RequestPart("item") Item item, @RequestPart(value = "image", required = false) MultipartFile imageData) throws IOException {
        itemService.updateItem(item, imageData);
    }

    // Delete item by ID
    @DeleteMapping("/delete-by-id/{itemId}")
    public void deleteItemById(@PathVariable Integer itemId) {
        itemService.deleteById(itemId);
    }

    // Get item by ID
    @GetMapping("/get-item-by-id/{itemId}")
    public ResponseEntity<Item> getItemById(@PathVariable Integer itemId) {
        Item item = itemService.searchByItemId(itemId).stream().findFirst().orElse(null);
        return item != null ? ResponseEntity.ok(item) : ResponseEntity.notFound().build();
    }

    // Get item by name
    @GetMapping("/get-item-by-name/{itemName}")
    public List<Item> getItemsByName(@PathVariable String itemName) {
        return itemService.searchByItemName(itemName);
    }

    // Get items by tea type
    @GetMapping("/get-item-by-tea-type/{teaType}")
    public List<Item> getItemsByTeaType(@PathVariable String teaType) {
        return itemService.searchByTeaType(teaType);
    }

    // Get the image of the item
    @GetMapping("/get-item-image/{itemId}")
    public ResponseEntity<byte[]> getItemImage(@PathVariable Integer itemId) {
        return itemService.getItemImageById(itemId);
    }
}
