package com.petscuentos.tienda_mascotas.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.petscuentos.tienda_mascotas.model.PurchaseOrder;

@Service
public interface PurchaseOrderService {
  List<PurchaseOrder> getAllPurchaseOrders();
    void createPurchaseOrder(PurchaseOrder purchaseOrder);
    PurchaseOrder getPurchaseOrderById(int id);
    void updatePurchaseOrder(int id, PurchaseOrder purchaseOrder);
    void deletePurchaseOrder(int id);
}
