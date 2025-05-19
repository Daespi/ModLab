
package com.example.Models.Product.DTO;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "product")
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

    @Column(name = "image_url", nullable = false, length = 1024)
    protected String imageUrls;

    @Column(name = "brand", nullable = false)
    protected String brand;

    public ProductDTO() {}

    public ProductDTO(
        String productId,
        String name,
        String description,
        double price,
        int stockQuantity,
        double rating,
        String imageUrls,
        String brand
    ) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.rating = rating;
        this.imageUrls = imageUrls;
        this.brand = brand;
    }

    public String getProductId() { return productId; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public double getPrice() { return price; }
    public int getStockQuantity() { return stockQuantity; }
    public double getRating() { return rating; }
    public String getImageUrls() { return imageUrls; }
    public String getBrand() { return brand; }
}
