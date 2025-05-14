// package com.example.Models.HardDrive.DTO;

// import com.example.Models.Product.DTO.ProductDTO;
// import jakarta.persistence.Column;
// import jakarta.persistence.DiscriminatorValue;
// import jakarta.persistence.Entity;
// import jakarta.persistence.Table;

// @Entity
// @Table(name = "hard_drive")
// @DiscriminatorValue("HARD_DRIVE")
// public class HardDriveDTO extends ProductDTO {

//     @Column(nullable = false, length = 50)
//     private String storageInterface;

//     @Column(nullable = false)
//     private boolean ssd;

//     @Column(nullable = false)
//     private int randomReading;

//     @Column(nullable = false)
//     private int capacity;

//     @Column(nullable = false)
//     private int writeSpeed;

//     @Column(nullable = false)
//     private double formFactor;

//     @Column(nullable = false)
//     private double width;

//     @Column(nullable = false)
//     private double high;

//     @Column(nullable = false)
//     private double length;

//     @Column(nullable = false)
//     private double weight;

//     @Column(nullable = false)
//     private boolean fragile;

//     public HardDriveDTO() {}

//     public HardDriveDTO(String productId, String name, String description, double price, int stockQuantity, double rating,
//                         String imageUrls, String brand, String storageInterface, boolean ssd, int randomReading, int capacity,
//                         int writeSpeed, double formFactor, double width, double high, double length, double weight, boolean fragile) {
//         super(productId, name, description, price, stockQuantity, rating, imageUrls, brand);

//         this.storageInterface = storageInterface;
//         this.ssd = ssd;
//         this.randomReading = randomReading;
//         this.capacity = capacity;
//         this.writeSpeed = writeSpeed;
//         this.formFactor = formFactor;
//         this.width = width;
//         this.high = high;

//         this.length = length;
//         this.weight = weight;
//         this.fragile = fragile;
//     }

//     public String getStorageInterface() { return storageInterface; }
//     public boolean isSsd() { return ssd; }
//     public int getRandomReading() { return randomReading; }
//     public int getCapacity() { return capacity; }
//     public int getWriteSpeed() { return writeSpeed; }
//     public double getFormFactor() { return formFactor; }
//     public double getWidth() { return width; }
//     public double getHigh() { return high; }
//     public double getLength() { return length; }
//     public double getWeight() { return weight; }
//     public boolean getFragile() { return fragile; }
// }
