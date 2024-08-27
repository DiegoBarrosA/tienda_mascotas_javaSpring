package com.petscuentos.tienda_mascotas.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    private int id;
    private String name;
    private String type;
    private int price;
    private String animaltype;
    private int stock;
}
