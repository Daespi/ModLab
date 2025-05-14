package com.example.Models.Motherboard.DTO;

import com.example.Models.Product.DTO.ProductDTO;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "motherboard")
@DiscriminatorValue("MOTHERBOARD")
public class MotherBoardDTO extends ProductDTO {

    @Column(nullable = false)
    private boolean cpu;

    @Column(nullable = false, length = 150)
    private String memory;

    @Column(nullable = false, length = 50)
    private String storage;

    @Column(nullable = false, length = 150)
    private String factorForm;

    @Column(nullable = false, length = 25)
    private String socket;

    @Column(nullable = false, length = 25)
    private String chipset;

    @Column(nullable = false, length = 25)
    private String memoryType;

    @Column(nullable = false)
    private int memorySlots;

    @Column(nullable = false)
    private int maxMemory;

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

    public MotherBoardDTO() {}

    public MotherBoardDTO(String productId, String name, String description, double price, int stockQuantity, double rating,
                           String imageUrls, String brand, boolean cpu, String memory, String storage, String factorForm,
                           String socket, String chipset, String memoryType, int memorySlots, int maxMemory,
                           double high, double width, double length, double weight, boolean fragile) {
        super(productId, name, description, price, stockQuantity, rating, imageUrls, brand);
        this.cpu = cpu;
        this.memory = memory;
        this.storage = storage;
        this.factorForm = factorForm;
        this.socket = socket;
        this.chipset = chipset;
        this.memoryType = memoryType;
        this.memorySlots = memorySlots;
        this.maxMemory = maxMemory;
        this.high = high;
        this.width = width;
        this.length = length;
        this.weight = weight;
        this.fragile = fragile;
    }

    public boolean getCpu() { return cpu; }
    public String getMemory() { return memory; }
    public String getStorage() { return storage; }
    public String getFactorForm() { return factorForm; }
    public String getSocket() { return socket; }
    public String getChipset() { return chipset; }
    public String getMemoryType() { return memoryType; }
    public int getMemorySlots() { return memorySlots; }
    public int getMaxMemory() { return maxMemory; }
    public double getHigh() { return high; }
    public double getWidth() { return width; }
    public double getLength() { return length; }
    public double getWeight() { return weight; }
    public boolean getFragile() { return fragile; }
}
