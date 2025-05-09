package com.example.Models.HardDrive.DTO;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

@Entity
@Table(name = "hard_drive", schema = "modlab")
public class HardDriveDTO {

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

    @Column(name = "storage_interface", nullable = false)
    private String storageInterface;

    @Column(name = "ssd", nullable = false)
    private boolean ssd;

    @Column(name = "random_reading", nullable = false)
    private int randomReading;

    @Column(name = "capacity", nullable = false)
    private int capacity;

    @Column(name = "write_speed", nullable = false)
    private int writeSpeed;

    @Column(name = "form_factor", nullable = false)
    private double formFactor;

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

    public HardDriveDTO() {
    }

    @JsonCreator
    public HardDriveDTO(
            @JsonProperty("name") String name,
            @JsonProperty("description") String description,
            @JsonProperty("price") double price,
            @JsonProperty("stockQuantity") int stockQuantity,
            @JsonProperty("rating") double rating,
            @JsonProperty("brand") String brand,
            @JsonProperty("storageInterface") String storageInterface,
            @JsonProperty("ssd") boolean ssd,
            @JsonProperty("randomReading") int randomReading,
            @JsonProperty("capacity") int capacity,
            @JsonProperty("writeSpeed") int writeSpeed,
            @JsonProperty("formFactor") double formFactor,
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
        this.storageInterface = storageInterface;
        this.ssd = ssd;
        this.randomReading = randomReading;
        this.capacity = capacity;
        this.writeSpeed = writeSpeed;
        this.formFactor = formFactor;
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

    public String getStorageInterface() {
        return storageInterface;
    }

    public boolean isSsd() {
        return ssd;
    }

    public int getRandomReading() {
        return randomReading;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getWriteSpeed() {
        return writeSpeed;
    }

    public double getFormFactor() {
        return formFactor;
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
        return "HardDriveDTO [name=" + name + ", description=" + description + ", price=" + price +
                ", stockQuantity=" + stockQuantity + ", rating=" + rating + ", brand=" + brand +
                ", storageInterface=" + storageInterface + ", ssd=" + ssd + ", randomReading=" + randomReading +
                ", capacity=" + capacity + ", writeSpeed=" + writeSpeed + ", formFactor=" + formFactor +
                ", high=" + high + ", width=" + width + ", length=" + length + ", weight=" + weight +
                ", fragile=" + fragile + "]";
    }
}
