package com.petscuentos.tienda_mascotas.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

import java.util.List;
import com.petscuentos.tienda_mascotas.service.ProductService;
import com.petscuentos.tienda_mascotas.model.Product;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService bookingService;

    @GetMapping
    public List<Product> getAllProducts() {
        return bookingService.getAllProducts();
    }
    @GetMapping("/{id}")
    public Optional<Product>  getProductById(@PathVariable Integer id) {

        return bookingService.getProductById(id);
    }
    @PostMapping
    public Product createProductEntity(@RequestBody Product booking) {
       
        return   bookingService.createProduct(booking);
    }
    @PutMapping("/{id}")
    public Product  updateUser(@PathVariable Integer id, @RequestBody Product booking) {

        return bookingService.updateProduct(id, booking);
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Integer id) {
         bookingService.deleteProduct(id);
    }

}
