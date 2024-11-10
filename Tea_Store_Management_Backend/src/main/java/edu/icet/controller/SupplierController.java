package edu.icet.controller;

import edu.icet.dto.Supplier;
import edu.icet.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/supplier")
@CrossOrigin
public class SupplierController {
    final SupplierService supplierService;

    @GetMapping("/get-all")
    public List<Supplier> getSupplier() {
        return supplierService.getSupplier();
    }

    @PostMapping("/add-supplier")
    public void addSupplier(@RequestBody Supplier supplier) {
        supplierService.addSupplier(supplier);
    }

    @DeleteMapping("/delete-by-id/{supplierId}")
    public void deleteById(@PathVariable Integer supplierId) {
        supplierService.deleteById(supplierId);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public void updateSupplier(@RequestBody Supplier supplier) {
        supplierService.addSupplier(supplier);
    }


    @GetMapping("/get-supplier-by-Id/{supplierId}")
    public List<Supplier> getBySupplierId(@PathVariable Integer supplierId){
        return supplierService.searchBySupplierId(supplierId);
    }

    @GetMapping("/get-supplier-by-name/{name}")
    public List<Supplier> getByName(@PathVariable String name){
        return supplierService.searchBySupplierName(name);
    }


}
