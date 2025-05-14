package com.example.Models.Order.Entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.example.Models.Product.Entity.Product;
import com.example.Exceptions.BuildException;
import com.example.Operations.Checker;

public class Order {

    protected String orderId;
    protected LocalDateTime orderDate;
    protected String status;
    protected String userId;
    protected String paymentId;
    protected List<Product> products;

    protected Order() {
        this.orderDate = LocalDateTime.now();
        this.products = new ArrayList<>();
    }

    public static Order getInstance(String status, String userId, String paymentId) throws BuildException {
        String message = "";
        Order order = new Order();

        String uuid = UUID.randomUUID().toString().replace("-", "").substring(0, 32);
        order.orderId = uuid;

        if ((Checker.isNull(status)) != 0) message += "El estado no puede ser nulo.";
        else order.status = status;

        if ((Checker.isNull(userId)) != 0) message += "El userId no puede ser nulo.";
        else order.userId = userId;

        if ((Checker.isNull(paymentId)) != 0) message += "El paymentId no puede ser nulo.";
        else order.paymentId = paymentId;

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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public double getTotalPrice() {
        return products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", orderDate=" + orderDate +
                ", status='" + status + '\'' +
                ", userId='" + userId + '\'' +
                ", paymentId='" + paymentId + '\'' +
                ", totalPrice=" + getTotalPrice() +
                '}';
    }
}
