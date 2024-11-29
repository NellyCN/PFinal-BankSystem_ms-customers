package com.xyzbank.ms_customer.service.impl;

import com.xyzbank.ms_customer.model.Customer;
import com.xyzbank.ms_customer.repository.CustomerRepository;
import com.xyzbank.ms_customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // Constructor para inyectar el repositorio
    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();  // Obtiene todos los clientes de la base de datos
    }

}
