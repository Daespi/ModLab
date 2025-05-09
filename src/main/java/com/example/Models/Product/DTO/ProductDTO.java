package com.example.Models.Product.DTO;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class ProductDTO {

    @Id
    @Column(name = "product_id", nullable = false, length = 32)
    protected String productId;

    @Column(name = "name", nullable = false, length = 150)
    protected String name;

    @Column(name = "description", nullable = false, length = 1024)
    protected String description;

    @Column(name = "price", nullable = false)
    protected double price;

    @Column(name = "stock_quantity", nullable = false)
    protected int stockQuantity;

    @Column(name = "rating", nullable = false)
    protected double rating;

    @Column(name = "created_at", nullable = false)
    protected LocalDateTime createdAt;

    // Aquí almacenamos las URLs separadas por comas
    @Column(name = "image_url", nullable = false, length = 1024)
    protected String imageUrls;

    @Column(name = "brand", nullable = false)
    protected String brand;

    // Constructor vacío requerido por JPA
    public ProductDTO() {}

    // Constructor completo
    public ProductDTO(
        String productId,
        String name,
        String description,
        double price,
        int stockQuantity,
        double rating,
        LocalDateTime createdAt,
        String imageUrls,  // ← String coma-separada
        String brand
    ) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.rating = rating;
        this.createdAt = createdAt;
        this.imageUrls = imageUrls;
        this.brand = brand;
    }

    // Getters
    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public double getRating() {
        return rating;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getImageUrls() {
        return imageUrls;
    }

    public String getBrand() {
        return brand;
    }
}
