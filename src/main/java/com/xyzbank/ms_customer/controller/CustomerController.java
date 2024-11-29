package com.xyzbank.ms_customer.controller;

import com.xyzbank.ms_customer.model.Customer;
import com.xyzbank.ms_customer.service.CustomerService;

import java.util.List;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();   // Llama al servicio para obtener todos los clientes
    }
}