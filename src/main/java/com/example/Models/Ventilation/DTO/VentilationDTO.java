// package com.example.Models.Ventilation.DTO;

// <<<<<<< HEAD
// import com.example.Models.Product.DTO.ProductDTO;
// import jakarta.persistence.Column;
// import jakarta.persistence.DiscriminatorValue;
// import jakarta.persistence.Entity;
// import jakarta.persistence.Table;

// @Entity
// @Table(name = "ventilation")
// @DiscriminatorValue("VENTILATION")
// public class VentilationDTO extends ProductDTO {

//     @Column(nullable = false)
//     private boolean leds;

//     @Column(nullable = false, length = 32)
//     private String color;

//     @Column(nullable = false)
//     private int maxAirflow;

//     @Column(nullable = false)
//     private int rotationSpeed;

//     @Column(nullable = false)
//     private double noiseLevel;

//     @Column(nullable = false, length = 50)
//     private String bearingType;

//     @Column(nullable = false)
//     private int inputVoltage;

//     @Column(nullable = false)
//     private double high;

//     @Column(nullable = false)
//     private double width;

//     @Column(nullable = false)
//     private double length;

//     @Column(nullable = false)
//     private double weight;

//     @Column(nullable = false)
//     private boolean fragile;

//     public VentilationDTO() {}

//     public VentilationDTO(String productId, String name, String description, double price, int stockQuantity,
//                           double rating, String imageUrls, String brand, boolean leds, String color, int maxAirflow,
//                           int rotationSpeed, double noiseLevel, String bearingType, int inputVoltage,
//                           double high, double width, double length, double weight, boolean fragile) {
//         super(productId, name, description, price, stockQuantity, rating, imageUrls, brand);
// =======
// import com.fasterxml.jackson.annotation.JsonCreator;
// import com.fasterxml.jackson.annotation.JsonProperty;

// import jakarta.persistence.*;
// import java.util.Set;

// @Entity
// @Table(name = "ventilation", schema = "modlab")
// public class VentilationDTO {

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

//     @Column(name = "leds", nullable = false)
//     private boolean leds;

//     @Column(name = "color", nullable = false)
//     private String color;

//     @Column(name = "max_airflow", nullable = false)
//     private int maxAirflow;

//     @Column(name = "rotation_speed", nullable = false)
//     private int rotationSpeed;

//     @Column(name = "noise_level", nullable = false)
//     private double noiseLevel;

//     @Column(name = "bearing_type", nullable = false)
//     private String bearingType;

//     @Column(name = "input_voltage", nullable = false)
//     private int inputVoltage;

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

//     public VentilationDTO() {
//     }

//     @JsonCreator
//     public VentilationDTO(
//             @JsonProperty("name") String name,
//             @JsonProperty("description") String description,
//             @JsonProperty("price") double price,
//             @JsonProperty("stockQuantity") int stockQuantity,
//             @JsonProperty("rating") double rating,
//             @JsonProperty("brand") String brand,
//             @JsonProperty("leds") boolean leds,
//             @JsonProperty("color") String color,
//             @JsonProperty("maxAirflow") int maxAirflow,
//             @JsonProperty("rotationSpeed") int rotationSpeed,
//             @JsonProperty("noiseLevel") double noiseLevel,
//             @JsonProperty("bearingType") String bearingType,
//             @JsonProperty("inputVoltage") int inputVoltage,
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
// >>>>>>> origin/dev_ash
//         this.leds = leds;
//         this.color = color;
//         this.maxAirflow = maxAirflow;
//         this.rotationSpeed = rotationSpeed;
//         this.noiseLevel = noiseLevel;
//         this.bearingType = bearingType;
//         this.inputVoltage = inputVoltage;
//         this.high = high;
//         this.width = width;
//         this.length = length;
//         this.weight = weight;
//         this.fragile = fragile;
//     }

// <<<<<<< HEAD
//     public boolean isLeds() { return leds; }
//     public String getColor() { return color; }
//     public int getMaxAirflow() { return maxAirflow; }
//     public int getRotationSpeed() { return rotationSpeed; }
//     public double getNoiseLevel() { return noiseLevel; }
//     public String getBearingType() { return bearingType; }
//     public int getInputVoltage() { return inputVoltage; }
//     public double getHigh() { return high; }
//     public double getWidth() { return width; }
//     public double getLength() { return length; }
//     public double getWeight() { return weight; }
//     public boolean isFragile() { return fragile; }
// =======
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

//     public boolean isLeds() {
//         return leds;
//     }

//     public String getColor() {
//         return color;
//     }

//     public int getMaxAirflow() {
//         return maxAirflow;
//     }

//     public int getRotationSpeed() {
//         return rotationSpeed;
//     }

//     public double getNoiseLevel() {
//         return noiseLevel;
//     }

//     public String getBearingType() {
//         return bearingType;
//     }

//     public int getInputVoltage() {
//         return inputVoltage;
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
//         return "VentilationDTO [name=" + name + ", description=" + description + ", price=" + price +
//                 ", stockQuantity=" + stockQuantity + ", rating=" + rating + ", brand=" + brand + ", leds=" +
//                 leds + ", color=" + color + ", maxAirflow=" + maxAirflow + ", rotationSpeed=" + rotationSpeed +
//                 ", noiseLevel=" + noiseLevel + ", bearingType=" + bearingType + ", inputVoltage=" + inputVoltage +
//                 ", high=" + high + ", width=" + width + ", length=" + length + ", weight=" + weight + ", fragile=" +
//                 fragile + "]";
//     }
// >>>>>>> origin/dev_ash
// }
