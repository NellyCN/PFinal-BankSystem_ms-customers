package com.xyzbank.ms_customer.controller;

import com.xyzbank.ms_customer.model.Customer;
import com.xyzbank.ms_customer.service.CustomerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador REST para la gestión de clientes. Indica al framework que esta clase se usará para recibir peticiones HTTP
 * @RequiredArgsConstructor: Inyección de dependencias por constructor vía Lombok.
 * @RequestMapping("/customer"): Define la ruta base /customer para el API: http://localhost:8080/customer
 * @Tag: Clasificación de endpoints para la documentación Swagger/OpenAPI.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
@Tag(name = "Customer Controller", description = "Endpoints para la gestión de clientes en el sistema bancario")
public class CustomerController {

    /**
     * Inyección de dependencia mediante constructor (gracias a @RequiredArgsConstructor de Lombok).
     * Se declara como 'final' para garantizar la inmutabilidad y una inyección segura.
     */
    private final CustomerService customerService;

    /**
     * Obtiene la lista completa de clientes registrados.
     * @return Lista de objetos Customer en formato JSON.
     */
    @Operation(
            summary = "Listar todos los clientes",
            description = "Retorna una lista de todos los clientes registrados en la base de datos MySQL"
    )
    @GetMapping
    public List<Customer> getAllCustomers() {
        // Delega la lógica de negocio a la capa de servicio
        return customerService.getAllCustomers();   // Llama al servicio para obtener todos los clientes
    }
}