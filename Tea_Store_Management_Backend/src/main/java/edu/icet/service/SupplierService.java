package edu.icet.service;

import edu.icet.dto.Supplier;


import java.util.List;

public interface SupplierService {
    List<Supplier> getSupplier();

    void addSupplier(Supplier supplier);

    void deleteById(Integer supplierId);

    List<Supplier> searchBySupplierId(Integer supplierId);

    List<Supplier> searchBySupplierName(String name);

}
