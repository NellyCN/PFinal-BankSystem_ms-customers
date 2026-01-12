package com.xyzbank.ms_customer.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Entidad que representa la tabla de clientes en la base de datos.
 * @Entity: Mapea esta clase a una tabla relacional (por defecto "customer").
 * @Getter/@Setter: Genera automáticamente los métodos de acceso vía Lombok.
 * @Builder: Permite crear instancias usando el patrón de diseño Builder.
 */
@Getter
@Setter
@Entity     // Marca esta clase como una entidad persistente que estará asociada a una tabla en BD relacional
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // ID autoincrementable
    private Long id;    // Identificador único autoincrementable

    private String firstName;
    private String lastName;
    private String dni;
    private String email;

    /**
     * Constructor por defecto requerido por JPA.
     */
    public Customer() {
    }

    /**
     * Constructor completo para inicialización manual o uso con el Builder.
     */
    public Customer(Long id, String firstName, String lastName, String dni, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dni = dni;
        this.email = email;
    }
}