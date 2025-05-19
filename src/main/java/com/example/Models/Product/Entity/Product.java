package com.example.Models.Product.Entity;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import java.util.UUID;

import com.example.Exceptions.BuildException;
import com.example.Models.Review.Entity.Review;
import com.example.Operations.Checker;

public abstract class Product {
    protected String productId;
    protected String name;
    protected String description;
    protected double price;
    protected int stockQuantity;
    protected double rating;
    protected Set<String> imageUrl = new HashSet<>();
    protected String brand;
    protected ArrayList<Review> reviews = new ArrayList<>();


    protected Product() throws BuildException {
        checkData(name, description, price, stockQuantity, rating, brand);
    }

    
    protected void checkData(String name, String description, double price, int stockQuantity,
                             double rating, String brand) throws BuildException {

        String message = "";
    
        this.productId = UUID.randomUUID().toString().replace("-", "").substring(0, 32);
    
        int resultName = setName(name);
        if (resultName != 0) {
            message += "El nombre de este producto no es correcto porque " + Checker.getErrorMessage(resultName, 10, 150);
        }
    
        int resultDescription = setDescription(description);
        if (resultDescription != 0) {
            message += "La descripción de este producto no es correcta porque " + Checker.getErrorMessage(resultDescription, 50, 1024);
        }
    
        int resultPrice = setPrice(price);
        if (resultPrice != 0) {
            message += "El precio de este producto no es correcto porque " + Checker.getErrorMessage(resultPrice, 1.00, 0.00);
        }
    
        int resultStockQuantity = setStockQuantity(stockQuantity);
        if (resultStockQuantity != 0) {
            message += "El stock de este producto no es correcto porque " + Checker.getErrorMessage(resultStockQuantity, 0, 100);
        }

        int resultRating = setRating(rating);
        if (resultRating != 0) {
            message += "La valoración de este producto no es correcta porque " + Checker.getErrorMessage(resultRating, 0.00, 5.00);
        }
    
        int resultBrand = setBrand(brand);
        if (resultBrand != 0) {
            message += "La marca de este producto no es correcta porque " + Checker.getErrorMessage(resultBrand, 2, 50);
        }
    
        if (!message.isEmpty()) {
            throw new BuildException(message);
        }
    }
    

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public int setName(String name) {
        if (Checker.isNull(name) != 0) return -1;
        if (Checker.minLength(10, name) != 0) return -2;
        if (Checker.maxLenght(150, name) != 0) return -10;
        this.name = name;
        return 0;
    }

    public String getDescription() {
        return description;
    }

    public int setDescription(String description) {
        if (Checker.isNull(description) != 0) return -1;
        if (Checker.minLength(50, description) != 0) return -2;
        if (Checker.maxLenght(1024, description) != 0) return -10;
        this.description = description;
        return 0;
    }

    public double getPrice() {
        return price;
    }

    public int setPrice(double price) {
        if (Checker.nonZero(price) != 0) return -3;
        if (Checker.nonNegative(price) != 0) return -4;
        if (Checker.minValue(price, 1.00) != 0) return -6;
        this.price = price;
        return 0;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public int setStockQuantity(int stockQuantity) {
        if (Checker.nonNegative(stockQuantity) != 0) return -4;
        if (Checker.maxValue(stockQuantity, 100) != 0) return -5;
        if (Checker.minValue(stockQuantity, 0) != 0) return -6;
        this.stockQuantity = stockQuantity;
        return 0;
    }

    public double getRating() {
        return rating;
    }

    public int setRating(double rating) {
        if (Checker.nonNegative(rating) != 0) return -4;
        if (Checker.maxValue(rating, 5.00) != 0) return -5;
        this.rating = rating;
        return 0;
    }


    public String getImageUrl() {
        return String.join(",", imageUrl); // Une todas las URLs separadas por comas
    }
    

    public int addImageUrl(String imageUrls) {
        if (imageUrls == null || imageUrls.isEmpty()) return -1;
        if (Checker.isNull(imageUrls) != 0) return -2;
        if (Checker.minLength(3, imageUrls) != 0 || Checker.maxLenght(500, imageUrls) != 0) return -3;
        this.imageUrl.add(imageUrls);
        return 0;
    }

    public String getBrand() {
        return brand;
    }

    public int setBrand(String brand) {
        if (Checker.isNull(brand) != 0) return -1;
        if (Checker.minLength(2, brand) != 0) return -2;
        if (Checker.maxLenght(50, brand) != 0) return -10;
        this.brand = brand;
        return 0;
    }




    public ArrayList<Review> getReviews() {
        return reviews;
    }


    public String setReviews(int rating, String comment, LocalDateTime reviewDate, String productId, String userId) throws BuildException{

        try{
            reviews.add(Review.getInstance(rating, comment, reviewDate, productId, userId));
        } catch (BuildException ex){
            return ex.getMessage();
        }
        
        return ""; 
        
    }

    public void addReview(Review review) {
        this.reviews.add(review);
    }
}
