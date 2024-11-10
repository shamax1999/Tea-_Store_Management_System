package edu.icet.controller;

import edu.icet.dto.Item;
import edu.icet.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public void addItem(@RequestBody Item item) {
        itemService.addItem(item);
    }

    @DeleteMapping("/delete-by-id/{itemId}")
    public void deleteById(@PathVariable Integer itemId) {
        itemService.deleteById(itemId);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public void updateItem(@RequestBody Item item) {
        itemService.addItem(item); // Call update instead of add
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
