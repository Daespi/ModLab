package com.example.Models.Product.Entity;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.example.Exceptions.BuildException;
import com.example.Operations.Checker;

public abstract class Product {
    protected String productId;
    protected String name;
    protected String description;
    protected double price;
    protected int stockQuantity;
    protected double rating;
    protected LocalDateTime createdAt;
    protected String imageUrl;
    protected String brand;
    //protected ArrayList<Review> reviews;

    protected Product() throws BuildException {
        // Valida los datos con el método checkData
        checkData(name, description, price, stockQuantity, rating, imageUrl, brand);
    }
    

    protected void checkData( String name, String description, double price, int stockQuantity,
        double rating, String imageUrl, String brand) throws BuildException {

            String message = "";

            String uuid = java.util.UUID.randomUUID().toString();
            uuid.replace("-", "");
            uuid.substring(0, 32);
            productId = uuid;
            

            int resultName = setName(name);
            if (resultName != 0) {
                message += "El nombre de este producto no es correcto porque" + Checker.getErrorMessage(resultName, 10, 150);
            }

            int resultDescription = setDescription(description);
            if (resultDescription != 0) {
                message += "La descripción de este producto no es correcta porque" + Checker.getErrorMessage(resultDescription, 50, 1024);
            }

            int resultPrice = setPrice(price);
            if (resultPrice != 0) {
                message += "El precio de este producto no es correcto porque" + Checker.getErrorMessage(resultPrice, 1.00, 0.00);
            }

            int resultStockQuantity = setStockQuantity(stockQuantity);
            if (resultStockQuantity != 0) {
                message += "El stock de este producto no es correcto porque" + Checker.getErrorMessage(resultStockQuantity, 0, 100);
            }

            int resultImageUrl = setImageUrl(imageUrl);
            if (resultImageUrl != 0) {
                message += "La valoracion de este producto no es correcta porque" + Checker.getErrorMessage(resultImageUrl, 3, 30);
            }

            int resultRating = setRating(rating);
            if (resultRating != 0) {
                message += "La valoracion de este producto no es correcta porque" + Checker.getErrorMessage(resultRating, 0.00, 5.00);
            }

            int resultBrand = setBrand(brand);
            if (resultBrand != 0) {
                message += "La valoracion de este producto no es correcta porque" + Checker.getErrorMessage(resultBrand, 2, 50);
            }

            createdAt = LocalDateTime.now();

            if (message.length() > 0) {
                throw new BuildException(message);
            }
    }

    public String getProductId() {
        return productId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getName() {
        return name;
    }

    public int setName(String name) {
        if ((Checker.isNull(name)) != 0)
            return -1;
        if ((Checker.minLength(10, name)) != 0)
            return -2;
        if ((Checker.maxLenght(150, name)) != 0)
            return -10;
        this.name = name;
        return 0;
    }

    public String getDescription() {
        return description;
    }

    public int setDescription(String description) {
        if ((Checker.isNull(name)) != 0)
            return -1;
        if ((Checker.minLength(50, name)) != 0)
            return -2;
        if ((Checker.maxLenght(1024, name)) != 0)
            return -10;
        this.description = description;
        return 0;
    }

    public double getPrice() {
        return price;
    }

    public int setPrice(double price) {
        if ((Checker.nonZero(price)) != 0) return -3;
        if ((Checker.nonNegative(price)) != 0) return -4;
        if ((Checker.minValue(price, 1.00)) != 0) return -6;
        this.price = price;
        return 0;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public int setStockQuantity(int stockQuantity) {
        if ((Checker.nonNegative(stockQuantity)) != 0) return -4;
        if ((Checker.maxValue(stockQuantity, 100)) != 0) return -5; 
        if ((Checker.minValue(stockQuantity, 0)) != 0) return -6;
        this.stockQuantity = stockQuantity;
        return 0;
    }

    public double getRating() {
        return rating;
    }

    public int setRating(double rating) { //Lo pongo en Double o lo dejo en double preguntar Jose
        if ((Checker.nonNegative(stockQuantity)) != 0) return -4;
        if ((Checker.maxValue(stockQuantity, 5)) != 0) return -5; 
        this.rating = rating;
        return 0;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int setImageUrl(String imageUrl) {
        if ((Checker.isNull(name)) != 0)
            return -1;
        this.imageUrl = imageUrl;
        return 0;
    }

    public String getBrand() {
        return brand;
    }

    public int setBrand(String brand) {
        if ((Checker.isNull(name)) != 0)
            return -1;
        if ((Checker.minLength(2, name)) != 0)
            return -2;
        if ((Checker.maxLenght(50, name)) != 0)
            return -10;
        this.brand = brand;
        return 0;
    }


    

}
