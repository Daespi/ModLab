package com.example.Models.CPU.DTO;

import java.time.LocalDateTime;

import com.example.Models.Product.DTO.ProductDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;

@Entity
@Table(name = "cpu")
@DiscriminatorValue("CPU") // Si estás usando herencia con single table
public class CPUDTO extends ProductDTO {

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private int processorCore;

    @Column(nullable = false)
    private int numberThreads;

    @Column(nullable = false)
    private double baseClock;

    @Column(nullable = false)
    private double frecuency;

    @Column(nullable = false, length = 150)
    private String cacheMemory;

    @Column(nullable = false)
    private int tdp;

    @Column(nullable = false, length = 50)
    private String socket;

    @Column(nullable = false)
    private int lithography;

    @Column(nullable = false)
    private boolean hasIntegratedGraphics;

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

    public CPUDTO() {}

    public CPUDTO(String productId, String name, String description, double price, int stockQuantity, double rating, String imageUrls, String brand, String model,
                  int processorCore, int numberThreads, double baseClock, double frecuency,
                  String cacheMemory, int tdp, String socket, int lithography,
                  boolean hasIntegratedGraphics, double width, double high, double length,
                  double weight, boolean fragile) {
        super(productId, name, description, price, stockQuantity, rating, imageUrls, brand);
        this.model = model;
        this.processorCore = processorCore;
        this.numberThreads = numberThreads;
        this.baseClock = baseClock;
        this.frecuency = frecuency;
        this.cacheMemory = cacheMemory;
        this.tdp = tdp;
        this.socket = socket;
        this.lithography = lithography;
        this.hasIntegratedGraphics = hasIntegratedGraphics;
        this.width = width;
        this.high = high;
        this.length = length;
        this.weight = weight;
        this.fragile = fragile;
    }

    // Getters
    public String getModel() { return model; }
    public int getProcessorCore() { return processorCore; }
    public int getNumberThreads() { return numberThreads; }
    public double getBaseClock() { return baseClock; }
    public double getFrecuency() { return frecuency; }
    public String getCacheMemory() { return cacheMemory; }
    public int getTdp() { return tdp; }
    public String getSocket() { return socket; }
    public int getLithography() { return lithography; }
    public boolean isHasIntegratedGraphics() { return hasIntegratedGraphics; }
    public double getWidth() { return width; }
    public double getHigh() { return high; }
    public double getLength() { return length; }
    public double getWeight() { return weight; }
    public boolean isFragile() { return fragile; }
    public boolean getFragile() { return fragile; }
}
