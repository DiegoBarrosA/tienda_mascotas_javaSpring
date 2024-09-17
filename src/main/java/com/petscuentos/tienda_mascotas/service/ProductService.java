package com.petscuentos.tienda_mascotas.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.petscuentos.tienda_mascotas.model.Product;
import java.util.Optional;

@Service
public interface ProductService {
  List<Product> getAllProducts();
    Product createProduct(Product product);
    Optional<Product>  getProductById(Integer id);
    Product updateProduct(Integer id, Product product);
    void deleteProduct(Integer id);
}
