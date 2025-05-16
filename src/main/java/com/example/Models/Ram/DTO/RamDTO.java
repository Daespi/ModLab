// package com.example.Models.Ram.DTO;

// import com.fasterxml.jackson.annotation.JsonCreator;
// import com.fasterxml.jackson.annotation.JsonProperty;

// import jakarta.persistence.*;
// import java.util.HashSet;
// import java.util.Set;

// @Entity
// @Table(name = "ram", schema = "modlab")
// public class RamDTO {

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

//     @Column(name = "latency", nullable = false)
//     private String latency;

//     @Column(name = "type_ddr", nullable = false)
//     private String typeDdr;

//     @Column(name = "internal_memory", nullable = false)
//     private int internalMemory;

//     @Column(name = "memory_speed", nullable = false)
//     private String memorySpeed;

//     @Column(name = "led", nullable = false)
//     private Boolean led;

//     @Column(name = "memory_size", nullable = false)
//     private int memorySize;

//     @Column(name = "number_of_modules", nullable = false)
//     private int numberOfModules;

//     @Column(name = "voltage", nullable = false)
//     private String voltage;

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

//     public RamDTO() {
//     }

//     @JsonCreator
//     public RamDTO(
//             @JsonProperty("name") String name,
//             @JsonProperty("description") String description,
//             @JsonProperty("price") double price,
//             @JsonProperty("stockQuantity") int stockQuantity,
//             @JsonProperty("rating") double rating,
//             @JsonProperty("brand") String brand,
//             @JsonProperty("latency") String latency,
//             @JsonProperty("typeDdr") String typeDdr,
//             @JsonProperty("internalMemory") int internalMemory,
//             @JsonProperty("memorySpeed") String memorySpeed,
//             @JsonProperty("led") Boolean led,
//             @JsonProperty("memorySize") int memorySize,
//             @JsonProperty("numberOfModules") int numberOfModules,
//             @JsonProperty("voltage") String voltage,
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
//         this.latency = latency;
//         this.typeDdr = typeDdr;
//         this.internalMemory = internalMemory;
//         this.memorySpeed = memorySpeed;
//         this.led = led;
//         this.memorySize = memorySize;
//         this.numberOfModules = numberOfModules;
//         this.voltage = voltage;
//         this.high = high;
//         this.width = width;
//         this.length = length;
//         this.weight = weight;
//         this.fragile = fragile;
//     }

//     // Getters and Setters

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

//     public String getLatency() {
//         return latency;
//     }

//     public String getTypeDdr() {
//         return typeDdr;
//     }

//     public int getInternalMemory() {
//         return internalMemory;
//     }

//     public String getMemorySpeed() {
//         return memorySpeed;
//     }

//     public Boolean getLed() {
//         return led;
//     }

//     public int getMemorySize() {
//         return memorySize;
//     }

//     public int getNumberOfModules() {
//         return numberOfModules;
//     }

//     public String getVoltage() {
//         return voltage;
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
//         return "RamDTO [name=" + name + ", description=" + description + ", price=" + price +
//                 ", stockQuantity=" + stockQuantity + ", rating=" + rating + ", brand=" + brand + ", latency=" +
//                 latency + ", typeDdr=" + typeDdr + ", internalMemory=" + internalMemory + ", memorySpeed=" +
//                 memorySpeed + ", led=" + led + ", memorySize=" + memorySize + ", numberOfModules=" + numberOfModules +
//                 ", voltage=" + voltage + ", high=" + high + ", width=" + width + ", length=" + length + ", weight=" +
//                 weight + ", fragile=" + fragile + "]";
//     }
// }
