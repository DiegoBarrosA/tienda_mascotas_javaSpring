package com.petscuentos.tienda_mascotas.repository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.petscuentos.tienda_mascotas.model.PurchaseOrder;
import com.petscuentos.tienda_mascotas.model.Customer;
import com.petscuentos.tienda_mascotas.model.Product;


import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PurchaseOrderRepository {

    public Date parseDate(String date) {
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(date);
        } catch (ParseException e) {
            return null;
        }
     }
    private final List<PurchaseOrder> purchaseOrders = new ArrayList<>();

    public List<PurchaseOrder> findAll() {
        return purchaseOrders;
    }

    public void addPurchaseOrder(PurchaseOrder purchaseOrder) {
        purchaseOrders.add(purchaseOrder);
    }

    public PurchaseOrder findPurchaseOrderById(int id) {
        for (PurchaseOrder purchaseOrder : purchaseOrders) {
            if (purchaseOrder.getId() == id) {
                return purchaseOrder;
            }
        }
    return null;
    }

public void updatePurchaseOrder(int id, PurchaseOrder updatePurchaseOrder) {
    for (int i = 0; i < purchaseOrders.size(); i++) {
        if (purchaseOrders.get(i).getId() == id) {
            purchaseOrders.set(i, updatePurchaseOrder);
            return;
        }
    }
}

public void deletePurchaseOrder(int id) {
    for (int i = 0; i < purchaseOrders.size(); i++) {
        if (purchaseOrders.get(i).getId() == id) {
            purchaseOrders.remove(i);
            return;
        }
    }
}

    public PurchaseOrderRepository() {
        // Inicializar la listas con usuarios
        purchaseOrders.add(new PurchaseOrder(1,new Customer(1,"Pedro","Pablo","Reyes","Nueva Calle 33","p.p@example.com") ,parseDate("12/05/2024"),"Santiago","28313",new Product(1,"Collar","Accesorios",10000,"Perro",12))); 
        purchaseOrders.add(new PurchaseOrder(2,new Customer(2,"Gonzalo","Gabriel","Gonzales","Ultima Calle 223","g.g@example.com") ,parseDate("12/05/2024"),"Santiago","28313",new Product(2,"Pedigree Adulto 22Kg","Alimentos",20000,"Perro",100))); 

    }

}
