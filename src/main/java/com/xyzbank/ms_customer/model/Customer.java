package com.xyzbank.ms_customer.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Getter
@Setter
@Entity
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // ID autoincrementable
    private Long id;

    private String first_name;
    private String last_name;
    private String dni;
    private String email;

    // Constructor por defecto
    public Customer() {
    }

    // Constructor
    public Customer(Long id, String first_name, String last_name, String dni, String email)
    {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.dni = dni;
        this.email = email;
    }
}