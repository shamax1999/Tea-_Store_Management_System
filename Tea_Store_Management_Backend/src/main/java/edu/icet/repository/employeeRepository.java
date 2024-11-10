package edu.icet.repository;

import edu.icet.dto.Employee;
import edu.icet.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface employeeRepository extends JpaRepository<EmployeeEntity ,Integer> {

    List<EmployeeEntity> findByEmployeeId(Integer employeeId);


    List<EmployeeEntity> findByName(String name);

}
