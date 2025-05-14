package com.example.Models.ShopCart.DTO;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "shop_cart")
public class ShopCartDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cartId", nullable = false)
    protected int cartId;

    @Column(name = "userId", nullable = false, length = 32)
    protected String userId;

    @Column(name = "productId", nullable = false, length = 32)
    protected String productId;

    @Column(name = "quantity", nullable = false)
    protected int quantity;

    @Column(name = "dateAdded", nullable = false)
    protected LocalDateTime dateAdded;

    protected ShopCartDTO() {}

    public ShopCartDTO(int cartId, String userId, String productId, int quantity, LocalDateTime dateAdded) {
        this.cartId = cartId;
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
        this.dateAdded = dateAdded;
    }

    public int getCartId() {
        return cartId;
    }

    public String getUserId() {
        return userId;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }
}
