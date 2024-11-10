package edu.icet.service;

import edu.icet.dto.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomer();

    void addCustomer(Customer customer);

    void deleteById(Integer customerId);

    List<Customer> searchByCustomerId(Integer customerId);

    List<Customer> searchByCustomerName(String name);

}
