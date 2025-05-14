package com.example.Models.GraphicCard.DTO;

import com.example.Models.Product.DTO.ProductDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.DiscriminatorValue;

@Entity
@Table(name = "graphic_card")
@DiscriminatorValue("GRAPHIC_CARD") // Si estás usando herencia con single table
public class GraphicCardDTO extends ProductDTO {

    @Column(nullable = false)
    private String color;

    @Column(nullable = false)
    private int memory;

    @Column(nullable = false, length = 50)
    private String memoryType;

    @Column(nullable = false)
    private int recommendedPowerSupply;

    @Column(nullable = false)
    private double coreClock;  // Frecuencia base del GPU (MHz)

    @Column(nullable = false)
    private double boostClock;  // Frecuencia máxima del GPU (MHz)

    @Column(nullable = false)
    private int tdp;  // Consumo térmico en watts

    @Column(nullable = false, length = 150)
    private String interfaceConnection;  // Tipo de conexión, ej. PCIe 4.0 x16

    // Datos físicos
    @Column(nullable = false)
    private double width;

    @Column(nullable = false)
    private double high;

    @Column(nullable = false)
    private double length;

    @Column(nullable = false)
    private double weight;

    @Column(nullable = false)
    private boolean fragile;

    public GraphicCardDTO() {}

    public GraphicCardDTO(String productId, String name, String description, double price, int stockQuantity, double rating, 
                          String imageUrls, String brand, String color, int memory, String memoryType, 
                          int recommendedPowerSupply, double coreClock, double boostClock, int tdp, String interfaceConnection,
                          double width, double high, double length, double weight, boolean fragile) {
        super(productId, name, description, price, stockQuantity, rating, imageUrls, brand);
        this.color = color;
        this.memory = memory;
        this.memoryType = memoryType;
        this.recommendedPowerSupply = recommendedPowerSupply;
        this.coreClock = coreClock;
        this.boostClock = boostClock;
        this.tdp = tdp;
        this.interfaceConnection = interfaceConnection;
        this.width = width;
        this.high = high;
        this.length = length;
        this.weight = weight;
        this.fragile = fragile;
    }

    // Getters
    public String getColor() { return color; }
    public int getMemory() { return memory; }
    public String getMemoryType() { return memoryType; }
    public int getRecommendedPowerSupply() { return recommendedPowerSupply; }
    public double getCoreClock() { return coreClock; }
    public double getBoostClock() { return boostClock; }
    public int getTdp() { return tdp; }
    public String getInterfaceConnection() { return interfaceConnection; }
    public double getWidth() { return width; }
    public double getHigh() { return high; }
    public double getLength() { return length; }
    public double getWeight() { return weight; }
    public boolean isFragile() { return fragile; }
}
