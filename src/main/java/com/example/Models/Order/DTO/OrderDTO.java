package com.example.Models.Order.DTO;

import com.example.Models.Product.DTO.ProductDTO;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "order_table", schema = "modlab")  // Evita conflicto con la palabra reservada 'order'
public class OrderDTO {

    @Id
    @Column(name = "orderId", nullable = false, length = 32)
    private String orderId;

    @Column(name = "orderDate", nullable = false)
    private LocalDateTime orderDate;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "userId", nullable = false, length = 32)
    private String userId;

    @Column(name = "paymentId", nullable = false, length = 32)
    private String paymentId;

    @ManyToMany
    @JoinTable(
        name = "order_product",
        joinColumns = @JoinColumn(name = "order_id"),
        inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<ProductDTO> products = new ArrayList<>();

    public OrderDTO() {}

    public OrderDTO(String orderId, LocalDateTime orderDate, String status,
                    String userId, String paymentId, List<ProductDTO> products) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.status = status;
        this.userId = userId;
        this.paymentId = paymentId;
        this.products = products != null ? products : new ArrayList<>();
    }

    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }

    public LocalDateTime getOrderDate() { return orderDate; }
    public void setOrderDate(LocalDateTime orderDate) { this.orderDate = orderDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getPaymentId() { return paymentId; }
    public void setPaymentId(String paymentId) { this.paymentId = paymentId; }

    public List<ProductDTO> getProducts() { return products; }
    public void setProducts(List<ProductDTO> products) { this.products = products; }

    @Transient
    public double getTotalPrice() {
        return products.stream()
                .mapToDouble(ProductDTO::getPrice)
                .sum();
    }
}