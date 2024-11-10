package edu.icet.service.Impl;

import edu.icet.dto.Customer;
import edu.icet.entity.CustomerEntity;
import edu.icet.repository.customerRepository;
import edu.icet.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    final customerRepository repository;
    final ModelMapper mapper;

    @Override
    public List<Customer> getCustomer() {
        List<Customer> customers = new ArrayList<>();
        repository.findAll().forEach(customer->{
            customers.add(mapper.map(customer,Customer.class));
        });
        return  customers;
    }

    @Override
    public void addCustomer(Customer customer) {
        repository.save(mapper.map(customer, CustomerEntity.class));
    }

    @Override
    public void deleteById(Integer customerId) {
        repository.deleteById(customerId);

    }

    @Override
    public List<Customer> searchByCustomerId(Integer customerId) {
        List<Customer> customerList =new ArrayList<>();
        repository.findByCustomerId(customerId).forEach(entity->{
            customerList.add(mapper.map(entity, Customer.class));
        });
        return customerList;
    }

    @Override
    public List<Customer> searchByCustomerName(String name) {
        List<Customer> customerList =new ArrayList<>();
        repository.findByName(name).forEach(entity->{
            customerList.add(mapper.map(entity, Customer.class));
        });
        return customerList;
    }
}
