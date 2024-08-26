package com.petscuentos.tienda_mascotas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    private static List<Product> products = new ArrayList<>();

    public ProductController() {
        products.add(new Product(1, "Pedigree Adulto 24kg", "Alimento", 20000, "Canino", 200));
        products.add(new Product(2, "Collar con cascabel", "Accesorio", 5000, "Felino", 50));
        products.add(new Product(3, "Canel L", "Accesorio", 75000, "Canino", 50));

    }

@GetMapping("/product")
public List<Product> getProducts() {
    return products;
}

@GetMapping("/product/{id}")
public Product getProductById(@PathVariable("id") int id) {
    for (Product product : products) {
        if (product.getId() == id) {
            return product;
        }
    };
    return null;
}

}
