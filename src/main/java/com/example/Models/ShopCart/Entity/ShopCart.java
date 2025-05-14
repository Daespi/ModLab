package com.example.Models.ShopCart.Entity;

import java.time.LocalDateTime;

import com.example.Exceptions.BuildException;
import com.example.Operations.Checker;

public class ShopCart {

    protected int cartId; // ahora int, autogenerado por la base de datos
    protected String userId;
    protected String productId;
    protected int quantity;
    protected LocalDateTime dateAdded;

    protected ShopCart() {}

    public static ShopCart getInstance(String userId, String productId, int quantity) throws BuildException {
        String errors = "";
        ShopCart cart = new ShopCart();

        cart.dateAdded = LocalDateTime.now();

        if (Checker.isNull(userId) != 0) errors += "El userId no puede ser nulo. ";
        else cart.userId = userId;

        if (Checker.isNull(productId) != 0) errors += "El productId no puede ser nulo. ";
        else cart.productId = productId;

        if (quantity <= 0) errors += "La cantidad debe ser mayor que 0. ";
        else cart.quantity = quantity;

        if (!errors.isEmpty()) throw new BuildException(errors);
        return cart;
    }

    public int getCartId() {
        return cartId;
    }

    public String getUserId() {
        return userId;
    }

    public int setUserId(String userId) {
        if (Checker.isNull(userId) != 0) return -1;
        this.userId = userId;
        return 0;
    }

    public String getProductId() {
        return productId;
    }

    public int setProductId(String productId) {
        if (Checker.isNull(productId) != 0) return -1;
        this.productId = productId;
        return 0;
    }

    public int getQuantity() {
        return quantity;
    }

    public int setQuantity(int quantity) {
        if (quantity <= 0) return -1;
        this.quantity = quantity;
        return 0;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    @Override
    public String toString() {
        return "ShopCart [cartId=" + cartId + ", userId=" + userId + ", productId=" + productId +
               ", quantity=" + quantity + ", dateAdded=" + dateAdded + "]";
    }
}
