package com.example.Models.OrderDetail.DTO;

import jakarta.persistence.*;

@Entity
@Table(name = "order_detail")
public class OrderDetailDTO {

    @Id
    @Column(name = "order_detail_id", nullable = false, length = 32)
    private String orderDetailId;

    @Column(name = "order_id", nullable = false, length = 32)
    private String orderId;

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

    public String getOrderDetailId() {
        return orderDetailId;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}
