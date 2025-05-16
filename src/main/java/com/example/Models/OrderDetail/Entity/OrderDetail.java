package com.example.Models.OrderDetail.Entity;

import java.util.UUID;

import com.example.Exceptions.BuildException;
import com.example.Operations.Checker;

public class OrderDetail {

    protected String orderDetailId;
    protected String orderId;
    protected String productId;
    protected int quantity;
    protected double price; // precio unitario en el momento del pedido

    protected OrderDetail() {}

    public static OrderDetail getInstance(String orderId, String productId, int quantity, double price) throws BuildException {
        String errors = "";
        OrderDetail detail = new OrderDetail();

        detail.orderDetailId = UUID.randomUUID().toString().replace("-", "").substring(0, 32);

        if (Checker.isNull(orderId) != 0) errors += "El orderId no puede ser nulo. ";
        else detail.orderId = orderId;

        if (Checker.isNull(productId) != 0) errors += "El productId no puede ser nulo. ";
        else detail.productId = productId;

        if (quantity <= 0) errors += "La cantidad debe ser mayor a 0. ";
        else detail.quantity = quantity;

        if (price <= 0) errors += "El precio debe ser mayor a 0. ";
        else detail.price = price;

        if (!errors.isEmpty()) throw new BuildException(errors);

        return detail;
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

    public double getSubtotal() {
        return this.quantity * this.price;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderDetailId='" + orderDetailId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", productId='" + productId + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
