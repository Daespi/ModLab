package com.example.Models.OrderDetail.DTO;

import jakarta.persistence.*;

@Entity
@Table(name = "order_detail")
public class OrderDetailDTO {

    @Id
    @Column(name = "order_detail_id", nullable = false, length = 32)
    private String orderDetailId;

    @Column(name = "order_id", nullable = false, length = 32)
    private String orderId;  // solo el ID, no la entidad completa

    @Column(name = "product_id", nullable = false, length = 32)
    private String productId;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "price", nullable = false)
    private double price;

    protected OrderDetailDTO() {}

    public OrderDetailDTO(String orderDetailId, String orderId, String productId, int quantity, double price) {
        this.orderDetailId = orderDetailId;
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters y setters
    public String getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(String orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSubtotal() {
        return this.quantity * this.price;
    }
}
