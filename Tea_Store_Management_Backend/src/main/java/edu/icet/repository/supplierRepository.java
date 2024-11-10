package edu.icet.repository;

import edu.icet.entity.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface supplierRepository extends JpaRepository<SupplierEntity, Integer> {

    List<SupplierEntity> findBySupplierId(Integer supplierId);

    List<SupplierEntity> findByName(String name);

}
