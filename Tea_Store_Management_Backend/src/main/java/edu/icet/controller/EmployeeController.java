package edu.icet.controller;

import edu.icet.dto.Employee;
import edu.icet.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/employee")
@CrossOrigin
public class EmployeeController {
    final EmployeeService employeeService;

    @GetMapping("/get-all")
    public List<Employee> getEmployee() {
        return employeeService.getEmployee();
    }

    @PostMapping("/add-employee")
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

    @DeleteMapping("/delete-by-id/{employeeId}")
    public void deleteById(@PathVariable Integer employeeId) {
        employeeService.deleteById(employeeId);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public void updateEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }


    @GetMapping("/get-employee-by-Id/{employeeId}")
    public List<Employee> getByEmployeeId(@PathVariable Integer employeeId){
        return employeeService.searchByEmployeeId(employeeId);
    }

    @GetMapping("/get-employee-by-name/{name}")
    public List<Employee> getByName(@PathVariable String name){
        return employeeService.searchByEmployeeName(name);
    }


}
