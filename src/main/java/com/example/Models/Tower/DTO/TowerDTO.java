package com.example.Models.Tower.DTO;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tower", schema = "modlab")
public class TowerDTO {

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

    @Column(name = "form_factor", nullable = false)
    private String formFactor;

    @Column(name = "color", nullable = false)
    private String color;

    @ElementCollection
    @CollectionTable(name = "tower_connectors", joinColumns = @JoinColumn(name = "tower_name"))
    @Column(name = "connector")
    private Set<String> connectors;

    @Column(name = "material", nullable = false)
    private String material;

    @Column(name = "fan_support", nullable = false)
    private int fanSupport;

    @Column(name = "max_gpu_length", nullable = false)
    private int maxGpuLength;

    @Column(name = "max_cpu_cooler_height", nullable = false)
    private int maxCpuCoolerHeight;

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

    public TowerDTO() {
    }

    @JsonCreator
    public TowerDTO(
            @JsonProperty("name") String name,
            @JsonProperty("description") String description,
            @JsonProperty("price") double price,
            @JsonProperty("stockQuantity") int stockQuantity,
            @JsonProperty("rating") double rating,
            @JsonProperty("brand") String brand,
            @JsonProperty("formFactor") String formFactor,
            @JsonProperty("color") String color,
            @JsonProperty("connectors") Set<String> connectors,
            @JsonProperty("material") String material,
            @JsonProperty("fanSupport") int fanSupport,
            @JsonProperty("maxGpuLength") int maxGpuLength,
            @JsonProperty("maxCpuCoolerHeight") int maxCpuCoolerHeight,
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
        this.formFactor = formFactor;
        this.color = color;
        this.connectors = connectors;
        this.material = material;
        this.fanSupport = fanSupport;
        this.maxGpuLength = maxGpuLength;
        this.maxCpuCoolerHeight = maxCpuCoolerHeight;
        this.high = high;
        this.width = width;
        this.length = length;
        this.weight = weight;
        this.fragile = fragile;
    }

    // Getters and Setters

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

    public String getFormFactor() {
        return formFactor;
    }

    public String getColor() {
        return color;
    }

    public Set<String> getConnectors() {
        return connectors;
    }

    public String getMaterial() {
        return material;
    }

    public int getFanSupport() {
        return fanSupport;
    }

    public int getMaxGpuLength() {
        return maxGpuLength;
    }

    public int getMaxCpuCoolerHeight() {
        return maxCpuCoolerHeight;
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
        return "TowerDTO [name=" + name + ", description=" + description + ", price=" + price +
                ", stockQuantity=" + stockQuantity + ", rating=" + rating + ", brand=" + brand + ", formFactor=" +
                formFactor + ", color=" + color + ", connectors=" + connectors + ", material=" + material + 
                ", fanSupport=" + fanSupport + ", maxGpuLength=" + maxGpuLength + ", maxCpuCoolerHeight=" +
                maxCpuCoolerHeight + ", high=" + high + ", width=" + width + ", length=" + length + ", weight=" +
                weight + ", fragile=" + fragile + "]";
    }
}
