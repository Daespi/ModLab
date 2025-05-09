package com.example.Models.GraphicCard.DTO;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

@Entity
@Table(name = "graphic_card", schema = "modlab")
public class GraphicCardDTO {

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

    @Column(name = "memory", nullable = false)
    private int memory;

    @Column(name = "memory_type", nullable = false)
    private String memoryType;

    @Column(name = "recommended_power_supply", nullable = false)
    private int recommendedPowerSupply;

    @Column(name = "core_clock", nullable = false)
    private double coreClock;

    @Column(name = "boost_clock", nullable = false)
    private double boostClock;

    @Column(name = "tdp", nullable = false)
    private int tdp;

    @Column(name = "interface_connection", nullable = false)
    private String interfaceConnection;

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

    public GraphicCardDTO() {
    }

    @JsonCreator
    public GraphicCardDTO(
            @JsonProperty("name") String name,
            @JsonProperty("description") String description,
            @JsonProperty("price") double price,
            @JsonProperty("stockQuantity") int stockQuantity,
            @JsonProperty("rating") double rating,
            @JsonProperty("brand") String brand,
            @JsonProperty("color") String color,
            @JsonProperty("memory") int memory,
            @JsonProperty("memoryType") String memoryType,
            @JsonProperty("recommendedPowerSupply") int recommendedPowerSupply,
            @JsonProperty("coreClock") double coreClock,
            @JsonProperty("boostClock") double boostClock,
            @JsonProperty("tdp") int tdp,
            @JsonProperty("interfaceConnection") String interfaceConnection,
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
        this.memory = memory;
        this.memoryType = memoryType;
        this.recommendedPowerSupply = recommendedPowerSupply;
        this.coreClock = coreClock;
        this.boostClock = boostClock;
        this.tdp = tdp;
        this.interfaceConnection = interfaceConnection;
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

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
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

    public int getMemory() {
        return memory;
    }

    public String getMemoryType() {
        return memoryType;
    }

    public int getRecommendedPowerSupply() {
        return recommendedPowerSupply;
    }

    public double getCoreClock() {
        return coreClock;
    }

    public double getBoostClock() {
        return boostClock;
    }

    public int getTdp() {
        return tdp;
    }

    public String getInterfaceConnection() {
        return interfaceConnection;
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
        return "GraphicCardDTO [name=" + name + ", description=" + description + ", price=" + price +
                ", stockQuantity=" + stockQuantity + ", rating=" + rating + ", brand=" + brand +
                ", color=" + color + ", memory=" + memory + ", memoryType=" + memoryType +
                ", recommendedPowerSupply=" + recommendedPowerSupply + ", coreClock=" + coreClock +
                ", boostClock=" + boostClock + ", tdp=" + tdp + ", interfaceConnection=" + interfaceConnection +
                ", high=" + high + ", width=" + width + ", length=" + length + ", weight=" + weight +
                ", fragile=" + fragile + "]";
    }
}
