package com.example.Models.PowerSupply.DTO;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "power_supply", schema = "modlab")
public class PowerSupplyDTO {

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

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "color", nullable = false)
    private String color;

    @Column(name = "total_power", nullable = false)
    private int totalPower;

    @ElementCollection
    @CollectionTable(name = "connectors", joinColumns = @JoinColumn(name = "power_supply_id"))
    @Column(name = "connector")
    private Set<String> connectors;

    @Column(name = "frecuency", nullable = false)
    private String frecuency;

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

    public PowerSupplyDTO() {
        this.connectors = new HashSet<>();
    }

    @JsonCreator
    public PowerSupplyDTO(
            @JsonProperty("name") String name,
            @JsonProperty("description") String description,
            @JsonProperty("price") double price,
            @JsonProperty("stockQuantity") int stockQuantity,
            @JsonProperty("rating") double rating,
            @JsonProperty("brand") String brand,
            @JsonProperty("model") String model,
            @JsonProperty("color") String color,
            @JsonProperty("totalPower") int totalPower,
            @JsonProperty("connectors") Set<String> connectors,
            @JsonProperty("frecuency") String frecuency,
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
        this.model = model;
        this.color = color;
        this.totalPower = totalPower;
        this.connectors = connectors;
        this.frecuency = frecuency;
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

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getTotalPower() {
        return totalPower;
    }

    public Set<String> getConnectors() {
        return connectors;
    }

    public String getFrecuency() {
        return frecuency;
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
        return "PowerSupplyDTO [name=" + name + ", description=" + description + ", price=" + price +
                ", stockQuantity=" + stockQuantity + ", rating=" + rating + ", brand=" + brand + ", model=" +
                model + ", color=" + color + ", totalPower=" + totalPower + ", connectors=" + connectors +
                ", frecuency=" + frecuency + ", high=" + high + ", width=" + width + ", length=" + length +
                ", weight=" + weight + ", fragile=" + fragile + "]";
    }
}
