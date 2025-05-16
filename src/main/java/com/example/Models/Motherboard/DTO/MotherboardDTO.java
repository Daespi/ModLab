// package com.example.Models.Motherboard.DTO;

// import com.fasterxml.jackson.annotation.JsonCreator;
// import com.fasterxml.jackson.annotation.JsonProperty;

// import jakarta.persistence.*;

// @Entity
// @Table(name = "motherboard", schema = "modlab")
// public class MotherboardDTO {

//     @Id
//     @Column(name = "name")
//     private String name;

//     @Column(name = "description", nullable = false)
//     private String description;

//     @Column(name = "price", nullable = false)
//     private double price;

//     @Column(name = "stock_quantity", nullable = false)
//     private int stockQuantity;

//     @Column(name = "rating", nullable = false)
//     private double rating;

//     @Column(name = "brand", nullable = false)
//     private String brand;

//     @Column(name = "cpu", nullable = false)
//     private boolean cpu;

//     @Column(name = "memory", nullable = false)
//     private String memory;

//     @Column(name = "storage", nullable = false)
//     private String storage;

//     @Column(name = "factor_form", nullable = false)
//     private String factorForm;

//     @Column(name = "socket", nullable = false)
//     private String socket;

//     @Column(name = "chipset", nullable = false)
//     private String chipset;

//     @Column(name = "memory_type", nullable = false)
//     private String memoryType;

//     @Column(name = "memory_slots", nullable = false)
//     private int memorySlots;

//     @Column(name = "max_memory", nullable = false)
//     private int maxMemory;

//     @Column(name = "high", nullable = false)
//     private double high;

//     @Column(name = "width", nullable = false)
//     private double width;

//     @Column(name = "length", nullable = false)
//     private double length;

//     @Column(name = "weight", nullable = false)
//     private double weight;

//     @Column(name = "fragile", nullable = false)
//     private boolean fragile;

//     public MotherboardDTO() {
//     }

//     @JsonCreator
//     public MotherboardDTO(
//             @JsonProperty("name") String name,
//             @JsonProperty("description") String description,
//             @JsonProperty("price") double price,
//             @JsonProperty("stockQuantity") int stockQuantity,
//             @JsonProperty("rating") double rating,
//             @JsonProperty("brand") String brand,
//             @JsonProperty("cpu") boolean cpu,
//             @JsonProperty("memory") String memory,
//             @JsonProperty("storage") String storage,
//             @JsonProperty("factorForm") String factorForm,
//             @JsonProperty("socket") String socket,
//             @JsonProperty("chipset") String chipset,
//             @JsonProperty("memoryType") String memoryType,
//             @JsonProperty("memorySlots") int memorySlots,
//             @JsonProperty("maxMemory") int maxMemory,
//             @JsonProperty("high") double high,
//             @JsonProperty("width") double width,
//             @JsonProperty("length") double length,
//             @JsonProperty("weight") double weight,
//             @JsonProperty("fragile") boolean fragile
//     ) {
//         this.name = name;
//         this.description = description;
//         this.price = price;
//         this.stockQuantity = stockQuantity;
//         this.rating = rating;
//         this.brand = brand;
//         this.cpu = cpu;
//         this.memory = memory;
//         this.storage = storage;
//         this.factorForm = factorForm;
//         this.socket = socket;
//         this.chipset = chipset;
//         this.memoryType = memoryType;
//         this.memorySlots = memorySlots;
//         this.maxMemory = maxMemory;
//         this.high = high;
//         this.width = width;
//         this.length = length;
//         this.weight = weight;
//         this.fragile = fragile;
//     }

//     // Getters y Setters

//     public String getName() {
//         return name;
//     }

//     public String getDescription() {
//         return description;
//     }

//     public double getPrice() {
//         return price;
//     }

//     public int getStockQuantity() {
//         return stockQuantity;
//     }

//     public double getRating() {
//         return rating;
//     }

//     public String getBrand() {
//         return brand;
//     }

//     public boolean isCpu() {
//         return cpu;
//     }

//     public String getMemory() {
//         return memory;
//     }

//     public String getStorage() {
//         return storage;
//     }

//     public String getFactorForm() {
//         return factorForm;
//     }

//     public String getSocket() {
//         return socket;
//     }

//     public String getChipset() {
//         return chipset;
//     }

//     public String getMemoryType() {
//         return memoryType;
//     }

//     public int getMemorySlots() {
//         return memorySlots;
//     }

//     public int getMaxMemory() {
//         return maxMemory;
//     }

//     public double getHigh() {
//         return high;
//     }

//     public double getWidth() {
//         return width;
//     }

//     public double getLength() {
//         return length;
//     }

//     public double getWeight() {
//         return weight;
//     }

//     public boolean isFragile() {
//         return fragile;
//     }

//     @Override
//     public String toString() {
//         return "MotherboardDTO [name=" + name + ", description=" + description + ", price=" + price +
//                 ", stockQuantity=" + stockQuantity + ", rating=" + rating + ", brand=" + brand +
//                 ", cpu=" + cpu + ", memory=" + memory + ", storage=" + storage + ", factorForm=" + factorForm +
//                 ", socket=" + socket + ", chipset=" + chipset + ", memoryType=" + memoryType + ", memorySlots=" +
//                 memorySlots + ", maxMemory=" + maxMemory + ", high=" + high + ", width=" + width + ", length=" +
//                 length + ", weight=" + weight + ", fragile=" + fragile + "]";
//     }
// }
