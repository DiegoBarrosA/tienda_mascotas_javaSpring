package com.petscuentos.tienda_mascotas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.petscuentos.tienda_mascotas.model.PurchaseOrder;
import com.petscuentos.tienda_mascotas.repository.PurchaseOrderRepository;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService{

 private final PurchaseOrderRepository purchaseOrderRepository = new PurchaseOrderRepository();

    @Override
    public List<PurchaseOrder> getAllPurchaseOrders(){
        return purchaseOrderRepository.findAll();
    }

    @Override
    public void createPurchaseOrder(PurchaseOrder purchaseOrder) {
        purchaseOrderRepository.addPurchaseOrder(purchaseOrder);
    }
    
    @Override
    public PurchaseOrder getPurchaseOrderById(int id) {
        return purchaseOrderRepository.findPurchaseOrderById(id);
    }

    @Override
    public void updatePurchaseOrder(int id, PurchaseOrder purchaseOrder) {
        purchaseOrderRepository.updatePurchaseOrder( id,purchaseOrder );
    }

    @Override
    public void deletePurchaseOrder(int id) {
        purchaseOrderRepository.deletePurchaseOrder(id);
    }
}
