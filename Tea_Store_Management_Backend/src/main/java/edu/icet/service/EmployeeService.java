package edu.icet.service;

import edu.icet.dto.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployee();

    void addEmployee(Employee employee);

    void deleteById(Integer employeeId);

    List<Employee> searchByEmployeeId(Integer employeeId);

    List<Employee> searchByEmployeeName(String name);

}
