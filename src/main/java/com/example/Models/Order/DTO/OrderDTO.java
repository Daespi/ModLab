package com.example.Models.Order.DTO;

import com.example.Models.OrderDetail.DTO.OrderDetailDTO;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "order_table", schema = "modlab")  // Evita palabra reservada SQL 'order'
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

    @Column(name = "address_id", nullable = false)
    private Integer addressId;

    public OrderDTO() {}

    public OrderDTO(String orderId, LocalDateTime orderDate, String status,
                    String userId, String paymentId, Integer addressId, List<OrderDetailDTO> orderDetails) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.status = status;
        this.userId = userId;
        this.paymentId = paymentId;
        this.addressId = addressId;
    }

    // Getters y setters
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

    public Integer getAddressId() { return addressId; }
    public void setAddressId(Integer addressId) { this.addressId = addressId; }

}
