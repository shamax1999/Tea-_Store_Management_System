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
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/item")
@CrossOrigin
public class ItemController {
    final ItemService itemService;

    @GetMapping("/get-all")
    public List<Item> getItem() {
        return itemService.getItem();
    }

    @PostMapping("/add-item")
    @ResponseStatus(HttpStatus.CREATED)
    public void addItem(@RequestPart("item") Item item, @RequestPart("image") MultipartFile imageData) throws IOException {
        itemService.addItem(item, imageData);
    }

    @DeleteMapping("/delete-by-id/{itemId}")
    public void deleteById(@PathVariable Integer itemId) {
        itemService.deleteById(itemId);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public void updateItem(@RequestPart("item") Item item, @RequestPart(value = "image", required = false) MultipartFile imageData) throws IOException {
        itemService.updateItem(item, imageData);
    }



    @GetMapping("/get-item-by-Id/{itemId}")
    public List<Item> getByItemId(@PathVariable Integer itemId){
        return itemService.searchByItemId(itemId);
    }

    @GetMapping("/get-item-by-name/{itemName}")
    public List<Item> getByName(@PathVariable String itemName){
        return itemService.searchByItemName(itemName);
    }

    @GetMapping("/get-item-by-teaType/{teaType}")
    public List<Item> getByTeaType(@PathVariable String teaType){
        return itemService.searchByTeaType(teaType);
    }

}
