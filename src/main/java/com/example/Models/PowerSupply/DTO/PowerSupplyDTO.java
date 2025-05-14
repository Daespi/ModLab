package com.example.Models.PowerSupply.DTO;

import com.example.Models.Product.DTO.ProductDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "powersupply")
@DiscriminatorValue("POWERSUPPLY")
public class PowerSupplyDTO extends ProductDTO {

    @Column(nullable = false, length = 20)
    private String model;

    @Column(nullable = false, length = 15)
    private String color;

    @Column(nullable = false)
    private int totalPower;

    @Column(nullable = false, length = 50)
    private String connectors;

    @Column(nullable = false, length = 15)
    private String frecuency;

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

    public PowerSupplyDTO() {}

    public PowerSupplyDTO(String productId, String name, String description, double price, int stockQuantity, double rating,
                          String imageUrls, String brand, String model, String color, int totalPower, String connectors,
                          String frecuency, double high, double width, double length, double weight, boolean fragile) {
        super(productId, name, description, price, stockQuantity, rating, imageUrls, brand);
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

    public String getModel() { return model; }
    public String getColor() { return color; }
    public int getTotalPower() { return totalPower; }
    public String getConnectors() { return connectors; }
    public String getFrecuency() { return frecuency; }
    public double getHigh() { return high; }
    public double getWidth() { return width; }
    public double getLength() { return length; }
    public double getWeight() { return weight; }
    public boolean getFragile() { return fragile; }
}
