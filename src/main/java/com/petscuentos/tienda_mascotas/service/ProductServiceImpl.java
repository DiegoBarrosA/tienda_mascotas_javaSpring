package com.petscuentos.tienda_mascotas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petscuentos.tienda_mascotas.model.Product;
import com.petscuentos.tienda_mascotas.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
@Autowired

 private  ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(Product product) {
      return  productRepository.save(product);
    }
    
    @Override
    public Optional<Product>  getProductById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public Product updateProduct(Integer id, Product product) {
        if(productRepository.existsById(id)){
            product.setId(id);
            return productRepository.save(product);
        }else{return null; }    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }
}
