package com.petscuentos.tienda_mascotas.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class PurchaseOrder {
private int id;
private Customer customer;
private Date shippingDate;
private String city;
private String zipCode;
private Product product;
}
