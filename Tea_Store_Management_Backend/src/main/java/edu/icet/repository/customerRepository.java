package edu.icet.repository;

import edu.icet.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface customerRepository extends JpaRepository<CustomerEntity, Integer> {

    List<CustomerEntity> findByCustomerId(Integer customerId);

    List<CustomerEntity> findByName(String name);

}
