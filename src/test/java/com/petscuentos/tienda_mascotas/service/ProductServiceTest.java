package com.petscuentos.tienda_mascotas.service;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.petscuentos.tienda_mascotas.model.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.petscuentos.tienda_mascotas.repository.ProductRepository;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @InjectMocks
    private ProductServiceImpl productService;
    @Mock
    private ProductRepository productRepositoryMock;
    @Test
    public void saveProductTest() {
        Product Product = new Product();
        Product.setName("Product A");
        Product.setAnimaltype("Dog");
        Product.setPrice(10000);
        Product.setStock(20);
        Product.setType("Accesory");
        when(productRepositoryMock.save(any())).thenReturn(Product);
        Product result = productService.createProduct(Product);
        assertEquals("Product A", result.getName());
        assertEquals("Dog", result.getAnimaltype());
        assertEquals(10000, result.getPrice());
        assertEquals(20, result.getStock());    
        assertEquals("Accesory", result.getType());

}
}