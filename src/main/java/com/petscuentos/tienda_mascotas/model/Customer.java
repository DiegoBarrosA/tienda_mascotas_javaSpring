package com.petscuentos.tienda_mascotas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {
    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String address;
    private String emailAddress;
}
