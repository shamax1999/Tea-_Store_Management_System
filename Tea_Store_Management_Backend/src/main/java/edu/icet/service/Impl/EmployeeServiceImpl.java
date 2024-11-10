package edu.icet.service.Impl;

import edu.icet.dto.Employee;
import edu.icet.entity.EmployeeEntity;
import edu.icet.repository.employeeRepository;
import edu.icet.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl  implements EmployeeService {
    final employeeRepository repository;
    final ModelMapper mapper;

    @Override
    public List<Employee> getEmployee() {
        List<Employee> employees = new ArrayList<>();
        repository.findAll().forEach(employee->{
            employees.add(mapper.map(employee,Employee.class));
        });
        return  employees;
    }

    @Override
    public void addEmployee(Employee employee) {
        repository.save(mapper.map(employee, EmployeeEntity.class));
    }

    @Override
    public void deleteById(Integer employeeId) {
        repository.deleteById(employeeId);
    }

    @Override
    public List<Employee> searchByEmployeeId(Integer employeeId) {
        List<Employee> employeeList =new ArrayList<>();
        repository.findByEmployeeId(employeeId).forEach(entity->{
            employeeList.add(mapper.map(entity, Employee.class));
        });
        return employeeList;
    }

    @Override
    public List<Employee> searchByEmployeeName(String name) {
        List<Employee> employeeList =new ArrayList<>();
        repository.findByName(name).forEach(entity->{
            employeeList.add(mapper.map(entity, Employee.class));
        });
        return employeeList;
    }


}
