package com.petscuentos.tienda_mascotas.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.petscuentos.tienda_mascotas.model.PurchaseOrder;
import java.util.Optional;

@Service
public interface PurchaseOrderService {
  List<PurchaseOrder> getAllPurchaseOrders();
    PurchaseOrder createPurchaseOrder(PurchaseOrder purchaseOrder);
    Optional<PurchaseOrder>  getPurchaseOrderById(Integer id);
    PurchaseOrder updatePurchaseOrder(Integer id, PurchaseOrder purchaseOrder);
    void deletePurchaseOrder(Integer id);
}
