package com.petscuentos.tienda_mascotas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petscuentos.tienda_mascotas.model.PurchaseOrder;
import com.petscuentos.tienda_mascotas.repository.PurchaseOrderRepository;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService{
@Autowired

 private  PurchaseOrderRepository purchaseOrderRepository;

    @Override
    public List<PurchaseOrder> getAllPurchaseOrders(){
        return purchaseOrderRepository.findAll();
    }

    @Override
    public PurchaseOrder createPurchaseOrder(PurchaseOrder purchaseOrder) {
      return  purchaseOrderRepository.save(purchaseOrder);
    }
    
    @Override
    public Optional<PurchaseOrder>  getPurchaseOrderById(Integer id) {
        return purchaseOrderRepository.findById(id);
    }

    @Override
    public PurchaseOrder updatePurchaseOrder(Integer id, PurchaseOrder purchaseOrder) {
        if(purchaseOrderRepository.existsById(id)){
            purchaseOrder.setId(id);
            return purchaseOrderRepository.save(purchaseOrder);
        }else{return null; }    }

    @Override
    public void deletePurchaseOrder(Integer id) {
        purchaseOrderRepository.deleteById(id);
    }
}
