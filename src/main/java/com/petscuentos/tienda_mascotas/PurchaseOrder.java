package com.petscuentos.tienda_mascotas;
import java.util.Date;

public class PurchaseOrder {
private int id;
private int customerId;
private Date shippingDate;
private String city;
private String zipCode;
private int productId;

public int getId() {
    return id;
}
public void setId(int id) {
    this.id = id;
}
public int getCustomerId() {
    return customerId;
}
public void setCustomerId(int customerId) {
    this.customerId = customerId;
}
public Date getShippingDate() {
    return shippingDate;
}
public void setShippingDate(Date shippingDate) {
    this.shippingDate = shippingDate;
}
public String getCity() {
    return city;
}
public void setCity(String city) {
    this.city = city;
}
public String getZipCode() {
    return zipCode;
}
public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
}
public int getProductId() {
    return productId;
}
public void setProductId(int productId) {
    this.productId = productId;
}
public PurchaseOrder(int id, int customerId, Date shippingDate, String city, String zipCode, int productId) {
    this.id = id;
    this.customerId = customerId;
    this.shippingDate = shippingDate;
    this.city = city;
    this.zipCode = zipCode;
    this.productId = productId;
}


}
