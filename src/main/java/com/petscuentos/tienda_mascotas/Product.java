package com.petscuentos.tienda_mascotas;

import java.util.ArrayList;
import java.util.List;

public class Product {
private int id;
private String name;
private String type;
private int price;
private String animaltype;
private int stock;
public int getId() {
    return id;
}
public void setId(int id) {
    this.id = id;
}
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
public String getType() {
    return type;
}
public void setType(String type) {
    this.type = type;
}
public int getPrice() {
    return price;
}
public void setPrice(int price) {
    this.price = price;
}
public String getAnimaltype() {
    return animaltype;
}
public void setAnimaltype(String animaltype) {
    this.animaltype = animaltype;
}
public int getStock() {
    return stock;
}
public void setStock(int stock) {
    this.stock = stock;
}
public Product(int id, String name, String type, int price, String animaltype, int stock) {
    this.id = id;
    this.name = name;
    this.type = type;
    this.price = price;
    this.animaltype = animaltype;
    this.stock = stock;
}
}
