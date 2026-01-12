package com.xyzbank.ms_customer.controller;

import com.xyzbank.ms_customer.model.Customer;
import com.xyzbank.ms_customer.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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

    @Test
    void shouldCreateCustomer() throws Exception {
        // 1. Preparar el objeto esperado (con ID simulado)
        Customer savedCustomer = new Customer(10L, "Luisa", "Pimentel", "65565455", "lupimentel@gmail.com");

        // 2. Simular el comportamiento del servicio
        when(customerService.saveCustomer(any(Customer.class))).thenReturn(savedCustomer);

        // 3. Ejecutar la petición POST
        mockMvc.perform(post("/customer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"firstName\":\"Luisa\", \"lastName\":\"Pimentel\", \"dni\":\"65565455\", \"email\":\"lupimentel@gmail.com\"}"))
                .andExpect(status().isCreated()) // Verifica el código 201
                .andExpect(jsonPath("$.id").value(10))
                .andExpect(jsonPath("$.firstName").value("Luisa"));
    }

    @Test
    void shouldDeleteCustomer() throws Exception {
        // 1. Simular que el servicio no hace nada (void) al recibir el ID
        doNothing().when(customerService).deleteCustomer(1L);

        // 2. Ejecutar la petición DELETE
        mockMvc.perform(delete("/customer/1"))
                .andExpect(status().isNoContent()); // Verifica el código 204

        // 3. Verificar que el servicio fue llamado exactamente una vez
        verify(customerService, times(1)).deleteCustomer(1L);
    }

}
