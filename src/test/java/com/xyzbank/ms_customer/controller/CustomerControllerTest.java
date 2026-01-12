package com.xyzbank.ms_customer.controller;

import com.xyzbank.ms_customer.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerController.class) // Indica que es un test específico para este controlador
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;    // El simulador de peticiones HTTP

    @MockBean
    private CustomerService customerService;    // El simulador de la lógica de negocio

    @Test
    void shouldReturnCustomerList() throws Exception {
        // 1. Configuración del Mock: Cuando el servicio sea llamado, devuelve lista vacía
        when(customerService.getAllCustomers()).thenReturn(Collections.emptyList());

        // 2. Ejecución y Verificación: Simula el GET y espera un 200 OK
        mockMvc.perform(get("/customer"))
                .andExpect(status().isOk()); // Esto marcará el método del Controller como "ok"
    }
}
