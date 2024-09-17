package com.petscuentos.tienda_mascotas.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "purchase_order")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PurchaseOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @OneToOne
    @JoinColumn(name = "customer", referencedColumnName = "id")
    private Customer customer;
    @Column(name = "shippingDate")
    private Date shippingDate;
    @Column(name = "city")
    private String city;
    @Column(name = "zipCode")
    private String zipCode;
    @OneToOne
    @JoinColumn(name = "product", referencedColumnName = "id")
    private Product product;
}
