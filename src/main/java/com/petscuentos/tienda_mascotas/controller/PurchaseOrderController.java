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
import java.util.Optional;

import java.util.List;
import com.petscuentos.tienda_mascotas.service.PurchaseOrderService;
import com.petscuentos.tienda_mascotas.model.PurchaseOrder;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/purchase-order")
@RequiredArgsConstructor
public class PurchaseOrderController {
    private final PurchaseOrderService bookingService;

    @GetMapping
    public List<PurchaseOrder> getAllPurchaseOrders() {
        return bookingService.getAllPurchaseOrders();
    }
    @GetMapping("/{id}")
    public Optional<PurchaseOrder>  getPurchaseOrderById(@PathVariable Integer id) {

        return bookingService.getPurchaseOrderById(id);
    }
    @PostMapping
    public PurchaseOrder createPurchaseOrderEntity(@RequestBody PurchaseOrder booking) {
       
        return   bookingService.createPurchaseOrder(booking);
    }
    @PutMapping("/{id}")
    public PurchaseOrder  updateUser(@PathVariable Integer id, @RequestBody PurchaseOrder booking) {

        return bookingService.updatePurchaseOrder(id, booking);
    }
    @DeleteMapping("/{id}")
    public void deletePurchaseOrder(@PathVariable Integer id) {
         bookingService.deletePurchaseOrder(id);
    }

}
