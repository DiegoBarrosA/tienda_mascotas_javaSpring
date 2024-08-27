package com.petscuentos.tienda_mascotas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import com.petscuentos.tienda_mascotas.service.PurchaseOrderService;
import com.petscuentos.tienda_mascotas.model.PurchaseOrder;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/purchase-order")
@RequiredArgsConstructor
public class PurchaseOrderController {


     
    private final PurchaseOrderService purchaseOrderService;
    
    @GetMapping
    public ResponseEntity<List<PurchaseOrder>> getAllPurchaseOrders() {
        List<PurchaseOrder> purchaseOrders = purchaseOrderService.getAllPurchaseOrders();
        if (purchaseOrders.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(purchaseOrders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseOrder> getPurchaseOrderById(@PathVariable int id) {
        PurchaseOrder purchaseOrder = purchaseOrderService.getPurchaseOrderById(id);
        if (purchaseOrder == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(purchaseOrder);
    }
    
    @PostMapping
    public ResponseEntity<Void> createPurchaseOrderEntity(@RequestBody PurchaseOrder purchaseOrder) {
        purchaseOrderService.createPurchaseOrder(purchaseOrder);
        return ResponseEntity.status(201).build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<PurchaseOrder>  updateUser(@PathVariable int id, @RequestBody PurchaseOrder purchaseOrder) {
        if (id !=purchaseOrder.getId() || purchaseOrderService.getPurchaseOrderById(id).equals(purchaseOrder)  || purchaseOrderService.getPurchaseOrderById(id) == null) 
        {
            return ResponseEntity.badRequest().build();
        }
        purchaseOrderService.updatePurchaseOrder(id, purchaseOrder);
        return ResponseEntity.ok().build();
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePurchaseOrder(@PathVariable int id) {
        if(purchaseOrderService.getPurchaseOrderById(id) == null){
            return ResponseEntity.badRequest().build();
        }
        purchaseOrderService.deletePurchaseOrder(id);
        return ResponseEntity.noContent().build();
    }

}
