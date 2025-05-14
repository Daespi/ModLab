package com.example.Models.Tower.DTO;

import com.example.Models.Product.DTO.ProductDTO;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tower")
@DiscriminatorValue("TOWER")
public class TowerDTO extends ProductDTO {

    @Column(nullable = false, length = 32)
    private String formFactor;

    @Column(nullable = false, length = 32)
    private String color;

    @Column(nullable = false, length = 50)
    private String connectors;

    @Column(nullable = false, length = 50)
    private String material;

    @Column(nullable = false)
    private int fanSupport;

    @Column(nullable = false)
    private int maxGpuLength;

    @Column(nullable = false)
    private int maxCpuCoolerHeight;

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

    public TowerDTO() {}

    public TowerDTO(String productId, String name, String description, double price, int stockQuantity, double rating,
                    String imageUrls, String brand, String formFactor, String color, String connectors, String material,
                    int fanSupport, int maxGpuLength, int maxCpuCoolerHeight, double high, double width,
                    double length, double weight, boolean fragile) {
        super(productId, name, description, price, stockQuantity, rating, imageUrls, brand);
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

    public String getFormFactor() { return formFactor; }
    public String getColor() { return color; }
    public String getConnectors() { return connectors; }
    public String getMaterial() { return material; }
    public int getFanSupport() { return fanSupport; }
    public int getMaxGpuLength() { return maxGpuLength; }
    public int getMaxCpuCoolerHeight() { return maxCpuCoolerHeight; }
    public double getHigh() { return high; }
    public double getWidth() { return width; }
    public double getLength() { return length; }
    public double getWeight() { return weight; }
    public boolean getFragile() { return fragile; }
}
