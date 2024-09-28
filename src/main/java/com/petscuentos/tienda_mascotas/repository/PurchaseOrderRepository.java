package com.petscuentos.tienda_mascotas.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.petscuentos.tienda_mascotas.model.PurchaseOrder;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Integer > {


}
