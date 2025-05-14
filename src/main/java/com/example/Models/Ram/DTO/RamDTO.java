package com.example.Models.Ram.DTO;

import com.example.Models.Product.DTO.ProductDTO;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "ram")
@DiscriminatorValue("RAM")
public class RamDTO extends ProductDTO {

    @Column(nullable = false, length = 20)
    private String latency;

    @Column(nullable = false, length = 15)
    private String typeDdr;

    @Column(nullable = false)
    private int internalMemory;

    @Column(nullable = false, length = 32)
    private String memorySpeed;

    @Column(nullable = false)
    private Boolean led;

    @Column(nullable = false)
    private int memorySize;

    @Column(nullable = false)
    private int numberOfModules;

    @Column(nullable = false, length = 32)
    private String voltage;

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

    public RamDTO() {}

    public RamDTO(String productId, String name, String description, double price, int stockQuantity, double rating,
                  String imageUrls, String brand, String latency, String typeDdr, int internalMemory, String memorySpeed,
                  Boolean led, int memorySize, int numberOfModules, String voltage,
                  double high, double width, double length, double weight, boolean fragile) {
        super(productId, name, description, price, stockQuantity, rating, imageUrls, brand);
        this.latency = latency;
        this.typeDdr = typeDdr;
        this.internalMemory = internalMemory;
        this.memorySpeed = memorySpeed;
        this.led = led;
        this.memorySize = memorySize;
        this.numberOfModules = numberOfModules;
        this.voltage = voltage;
        this.high = high;
        this.width = width;
        this.length = length;
        this.weight = weight;
        this.fragile = fragile;
    }

    public String getLatency() { return latency; }
    public String getTypeDdr() { return typeDdr; }
    public int getInternalMemory() { return internalMemory; }
    public String getMemorySpeed() { return memorySpeed; }
    public Boolean getLed() { return led; }
    public int getMemorySize() { return memorySize; }
    public int getNumberOfModules() { return numberOfModules; }
    public String getVoltage() { return voltage; }
    public double getHigh() { return high; }
    public double getWidth() { return width; }
    public double getLength() { return length; }
    public double getWeight() { return weight; }
    public boolean getFragile() { return fragile; }
}
