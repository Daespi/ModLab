package com.example.Models.Ventilation.DTO;

import com.example.Models.Product.DTO.ProductDTO;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "ventilation")
@DiscriminatorValue("VENTILATION")
public class VentilationDTO extends ProductDTO {

    @Column(nullable = false)
    private boolean leds;

    @Column(nullable = false, length = 32)
    private String color;

    @Column(nullable = false)
    private int maxAirflow;

    @Column(nullable = false)
    private int rotationSpeed;

    @Column(nullable = false)
    private double noiseLevel;

    @Column(nullable = false, length = 50)
    private String bearingType;

    @Column(nullable = false)
    private int inputVoltage;

    @Column(nullable = false)
    private double high;

    @Column(nullable = false)
    private double width;

    @Column(nullable = false)
    private double length;

    @Column(nullable = false)
    private double weight;

    @Column(nullable = false)
    private boolean fragile;

    public VentilationDTO() {}

    public VentilationDTO(String productId, String name, String description, double price, int stockQuantity,
                          double rating, String imageUrls, String brand, boolean leds, String color, int maxAirflow,
                          int rotationSpeed, double noiseLevel, String bearingType, int inputVoltage,
                          double high, double width, double length, double weight, boolean fragile) {
        super(productId, name, description, price, stockQuantity, rating, imageUrls, brand);
        this.leds = leds;
        this.color = color;
        this.maxAirflow = maxAirflow;
        this.rotationSpeed = rotationSpeed;
        this.noiseLevel = noiseLevel;
        this.bearingType = bearingType;
        this.inputVoltage = inputVoltage;
        this.high = high;
        this.width = width;
        this.length = length;
        this.weight = weight;
        this.fragile = fragile;
    }

    public boolean isLeds() { return leds; }
    public String getColor() { return color; }
    public int getMaxAirflow() { return maxAirflow; }
    public int getRotationSpeed() { return rotationSpeed; }
    public double getNoiseLevel() { return noiseLevel; }
    public String getBearingType() { return bearingType; }
    public int getInputVoltage() { return inputVoltage; }
    public double getHigh() { return high; }
    public double getWidth() { return width; }
    public double getLength() { return length; }
    public double getWeight() { return weight; }
    public boolean isFragile() { return fragile; }
}
