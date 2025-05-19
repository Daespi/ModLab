package com.example.Models.ShopCart.DTO;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "shop_cart")
public class ShopCartDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id", nullable = false)
    protected int cartId;

    @Column(name = "user_id", nullable = false, length = 200)
    protected String userId;

    @Column(name = "product_id", nullable = false, length = 32)
    protected String productId;

    @Column(name = "quantity", nullable = false)
    protected int quantity;


    protected ShopCartDTO() {}

    public ShopCartDTO(int cartId, String userId, String productId, int quantity) {
        this.cartId = cartId;
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
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

}
