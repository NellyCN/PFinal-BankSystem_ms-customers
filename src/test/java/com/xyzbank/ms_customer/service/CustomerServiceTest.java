package com.xyzbank.ms_customer.service;

import com.xyzbank.ms_customer.model.Customer;
import com.xyzbank.ms_customer.repository.CustomerRepository;
import com.xyzbank.ms_customer.service.impl.CustomerServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Test
    void shouldSaveCustomerSuccessfully() {
        // 1. Datos de prueba
        Customer customer = new Customer(null, "Luisa", "Pimentel", "65565455", "lupimentel@gmail.com");
        Customer savedCustomer = new Customer(1L, "Luisa", "Pimentel", "65565455", "lupimentel@gmail.com");

        // 2. Mock del repositorio
        when(customerRepository.save(any(Customer.class))).thenReturn(savedCustomer);

        // 3. Ejecución
        Customer result = customerService.saveCustomer(customer);

        // 4. Verificaciones
        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(customerRepository, times(1)).save(customer);
    }

    @Test
    void shouldDeleteCustomerSuccessfully() {
        // 1. Ejecución
        customerService.deleteCustomer(1L);

        // 2. Verificación: comprobamos que el repositorio recibió la orden de borrar
        verify(customerRepository, times(1)).deleteById(1L);
    }
}
