
package com.petscuentos.tienda_mascotas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PurchaseOrderController {
private static List<PurchaseOrder> purchaseOrders = new ArrayList<>();

public PurchaseOrderController(){

purchaseOrders.add(new PurchaseOrder(1, 1,DateUtils.parseDate("20/04/2024") , "Santiago", "252314", 1));
purchaseOrders.add(new PurchaseOrder(2, 1,DateUtils.parseDate("21/05/2024") , "Santiago", "252314", 1));
purchaseOrders.add(new PurchaseOrder(3, 2,DateUtils.parseDate("22/05/2024") , "Santiago", "312314", 2));
purchaseOrders.add(new PurchaseOrder(4, 3,DateUtils.parseDate("23/05/2024") , "Santiago", "413343", 2));
purchaseOrders.add(new PurchaseOrder(5, 4,DateUtils.parseDate("24/05/2024") , "Santiago", "893893", 3));


}


@GetMapping("/purchase-order")
public List<PurchaseOrder> getPurchaseOrders() {
    return purchaseOrders;
}
@GetMapping("/purchase-orders/{id}")
public PurchaseOrder getPurchaseOrdersById(@PathVariable("id") int id) {
    for (PurchaseOrder purchaseOrder : purchaseOrders) {
        if (purchaseOrder.getId() == id) {
            return purchaseOrder;
        }
    };
    return null;
}


}
