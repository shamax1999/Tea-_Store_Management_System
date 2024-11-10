package edu.icet.controller;

import edu.icet.dto.Customer;
import edu.icet.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {
    final CustomerService customerService;

    @GetMapping("/get-all")
    public List<Customer> getCustomer() {
        return customerService.getCustomer();
    }

    @PostMapping("/add-customer")
    public void addCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
    }

    @DeleteMapping("/delete-by-id/{customerId}")
    public void deleteById(@PathVariable Integer customerId) {
        customerService.deleteById(customerId);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public void updateCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
    }


    @GetMapping("/get-customer-by-Id/{customerId}")
    public List<Customer> getByCustomerId(@PathVariable Integer customerId){
        return customerService.searchByCustomerId(customerId);
    }

    @GetMapping("/get-customer-by-name/{name}")
    public List<Customer> getByName(@PathVariable String name){
        return customerService.searchByCustomerName(name);
    }


}
