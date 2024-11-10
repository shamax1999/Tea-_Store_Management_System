package edu.icet.controller;

import edu.icet.dto.TeaCollection;
import edu.icet.service.TeaCollectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/collection")
@CrossOrigin
public class TeaCollectionController {
    final TeaCollectionService teaCollectionService;

    @GetMapping("/get-all")
    public List<TeaCollection> getTeaCollection() {
        return teaCollectionService.getTeaCollection();
    }

    @PostMapping("/add-collection")
    public void addTeaCollection(@RequestBody TeaCollection teaCollection) {
        teaCollectionService.addTeaCollection(teaCollection);
    }

    @DeleteMapping("/delete-by-id/{collectionId}")
    public void deleteById(@PathVariable Integer collectionId) {
        teaCollectionService.deleteById(collectionId);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public void updateTeaCollection(@RequestBody TeaCollection teaCollection) {
        teaCollectionService.addTeaCollection(teaCollection);
    }


    @GetMapping("/get-collection-by-Id/{collectionId}")
    public List<TeaCollection> getByCollectionId(@PathVariable Integer collectionId){
        return teaCollectionService.searchByCollectionId(collectionId);
    }

    @GetMapping("/get-collection-by-supplierId/{supplierId}")
    public List<TeaCollection> getCollectionBySupplierId(@PathVariable Integer supplierId){
        return teaCollectionService.getCollectionBySupplierId(supplierId);
    }



}
