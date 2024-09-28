package com.petscuentos.tienda_mascotas.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.petscuentos.tienda_mascotas.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer > {


}
