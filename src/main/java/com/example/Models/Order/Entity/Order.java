package com.example.Models.Order.Entity;

import java.time.LocalDateTime;
import java.util.UUID;

import com.example.Exceptions.BuildException;
import com.example.Operations.Checker;

public class Order {

    protected String orderId;
    protected LocalDateTime orderDate;
    protected String status;
    protected String userId;
    protected String paymentId;
    protected Integer addressId;

    protected Order() {
        this.orderDate = LocalDateTime.now();
    }

    public static Order getInstance(String status, String userId, String paymentId, Integer addressId) throws BuildException {
        String message = "";
        Order order = new Order();

        String uuid = UUID.randomUUID().toString().replace("-", "").substring(0, 32);
        order.orderId = uuid;

        if ((Checker.isNull(status)) != 0) message += "El estado no puede ser nulo. ";
        else order.status = status;

        if ((Checker.isNull(userId)) != 0) message += "El userId no puede ser nulo. ";
        else order.userId = userId;

        if ((Checker.isNull(paymentId)) != 0) message += "El paymentId no puede ser nulo. ";
        else order.paymentId = paymentId;

        if (addressId == null) message += "El addressId no puede ser nulo. ";
        else order.addressId = addressId;

        if (!message.isEmpty()) throw new BuildException(message);

        return order;
    }

    public String getOrderId() {
        return orderId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public int setStatus(String status) {
        if ((Checker.isNull(status)) != 0) return -1;
        this.status = status;
        return 0;
    }

    public String getUserId() {
        return userId;
    }

    public int setUserId(String userId) {
        if ((Checker.isNull(userId)) != 0) return -1;
        this.userId = userId;
        return 0;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public int setPaymentId(String paymentId) {
        if ((Checker.isNull(paymentId)) != 0) return -1;
        this.paymentId = paymentId;
        return 0;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public int setAddressId(Integer addressId) {
        if (addressId == null) return -1;
        this.addressId = addressId;
        return 0;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", orderDate=" + orderDate +
                ", status='" + status + '\'' +
                ", userId='" + userId + '\'' +
                ", paymentId='" + paymentId + '\'' +
                ", addressId=" + addressId +
                '}';
    }
}
