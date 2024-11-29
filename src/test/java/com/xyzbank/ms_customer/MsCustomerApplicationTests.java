package com.xyzbank.ms_customer;

import com.xyzbank.ms_customer.model.Customer;
import com.xyzbank.ms_customer.repository.CustomerRepository;
import com.xyzbank.ms_customer.service.CustomerService;
import com.xyzbank.ms_customer.service.impl.CustomerServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class MsCustomerApplicationTests {

    @Mock
    private CustomerRepository customerRepository;

    private CustomerServiceImpl customerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        // Instanciar el servicio con el mock del repositorio
        customerService = new CustomerServiceImpl(customerRepository);
    }

    @Test
    void testGetAllCustomers() {
        // Datos simulados
        Customer customer1 = new Customer(1L, "John", "Doe", "12345678", "john.doe@example.com");
        Customer customer2 = new Customer(2L, "Jane", "Doe", "87654321", "jane.doe@example.com");
        List<Customer> mockCustomers = Arrays.asList(customer1, customer2);

        // Configurar el comportamiento del mock
        when(customerRepository.findAll()).thenReturn(mockCustomers);

        // Llamar al metodo a probar
        List<Customer> result = customerService.getAllCustomers();

        // Verificar los resultados
        assertEquals(2, result.size());
        assertEquals("John", result.get(0).getFirst_name());
        assertEquals("Jane", result.get(1).getFirst_name());
    }
}