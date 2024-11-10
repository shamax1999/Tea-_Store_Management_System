package edu.icet.service.Impl;

import edu.icet.dto.Supplier;
import edu.icet.entity.SupplierEntity;
import edu.icet.repository.supplierRepository;
import edu.icet.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    final supplierRepository repository;
    final ModelMapper mapper;

    @Override
    public List<Supplier> getSupplier() {
        List<Supplier> suppliers = new ArrayList<>();
        repository.findAll().forEach(supplier->{
            suppliers.add(mapper.map(supplier,Supplier.class));
        });
        return  suppliers;
    }

    @Override
    public void addSupplier(Supplier supplier) {
        repository.save(mapper.map(supplier, SupplierEntity.class));

    }

    @Override
    public void deleteById(Integer supplierId) {
        repository.deleteById(supplierId);

    }

    @Override
    public List<Supplier> searchBySupplierId(Integer supplierId) {
        List<Supplier> supplierList =new ArrayList<>();
        repository.findBySupplierId(supplierId).forEach(entity->{
            supplierList.add(mapper.map(entity, Supplier.class));
        });
        return supplierList;
    }

    @Override
    public List<Supplier> searchBySupplierName(String name) {
        List<Supplier> supplierList =new ArrayList<>();
        repository.findByName(name).forEach(entity->{
            supplierList.add(mapper.map(entity, Supplier.class));
        });
        return supplierList;
    }
}
