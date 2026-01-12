package com.xyzbank.ms_customer;

import com.xyzbank.ms_customer.model.Customer;
import com.xyzbank.ms_customer.repository.CustomerRepository;
import com.xyzbank.ms_customer.service.impl.CustomerServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
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
        // 1. Datos simulados (Mock Data)
        Customer customer1 = new Customer(1L, "John", "Doe", "12345678", "john.doe@example.com");
        Customer customer2 = new Customer(2L, "Jane", "Doe", "87654321", "jane.doe@example.com");
        List<Customer> mockCustomers = Arrays.asList(customer1, customer2);

        // 2. Configurar el comportamiento del mock (Simulamos el Repositorio)
        when(customerRepository.findAll()).thenReturn(mockCustomers);

        // 3. Llamar al método del SERVICIO
        List<Customer> result = customerService.getAllCustomers();

        // 4. Verificar los resultados (Corregido a camelCase)
        assertEquals(2, result.size());
        assertEquals("John", result.get(0).getFirstName());
        assertEquals("Jane", result.get(1).getFirstName());

        // Verificación adicional de que el repositorio fue llamado exactamente una vez
        verify(customerRepository, times(1)).findAll();
    }
}