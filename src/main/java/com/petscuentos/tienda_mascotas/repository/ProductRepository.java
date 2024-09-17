package com.petscuentos.tienda_mascotas.repository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.petscuentos.tienda_mascotas.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer > {


}
