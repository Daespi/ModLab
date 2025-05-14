package com.example.Models.Accessories.DTO;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

@Entity
@Table(name = "accessories", schema = "modlab")
public class AccessoriesDTO {

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "stock_quantity", nullable = false)
    private int stockQuantity;

    @Column(name = "rating", nullable = false)
    private double rating;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "color", nullable = false)
    private String color;

    @Column(name = "material", nullable = false)
    private String material;

    @Column(name = "high", nullable = false)
    private double high;

    @Column(name = "width", nullable = false)
    private double width;

    @Column(name = "length", nullable = false)
    private double length;

    @Column(name = "weight", nullable = false)
    private double weight;

    @Column(name = "fragile", nullable = false)
    private boolean fragile;

    public AccessoriesDTO() {
    }

    @JsonCreator
    public AccessoriesDTO(
            @JsonProperty("name") String name,
            @JsonProperty("description") String description,
            @JsonProperty("price") double price,
            @JsonProperty("stockQuantity") int stockQuantity,
            @JsonProperty("rating") double rating,
            @JsonProperty("brand") String brand,
            @JsonProperty("color") String color,
            @JsonProperty("material") String material,
            @JsonProperty("high") double high,
            @JsonProperty("width") double width,
            @JsonProperty("length") double length,
            @JsonProperty("weight") double weight,
            @JsonProperty("fragile") boolean fragile
    ) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.rating = rating;
        this.brand = brand;
        this.color = color;
        this.material = material;
        this.high = high;
        this.width = width;
        this.length = length;
        this.weight = weight;
        this.fragile = fragile;
    }

    // Getters y Setters
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

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public String getMaterial() {
        return material;
    }

    public double getHigh() {
        return high;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public double getWeight() {
        return weight;
    }

    public boolean isFragile() {
        return fragile;
    }

    @Override
    public String toString() {
        return "AccessoriesDTO [name=" + name + ", description=" + description + ", price=" + price +
                ", stockQuantity=" + stockQuantity + ", rating=" + rating + ", brand=" + brand + ", color=" +
                color + ", material=" + material + ", high=" + high + ", width=" + width + ", length=" + length +
                ", weight=" + weight + ", fragile=" + fragile + "]";
    }
}
