package com.example.Models.Accessories.Entity;

import com.example.Exceptions.BuildException;
import com.example.Models.Cpu.Entity.CPU;
import com.example.Models.PhysicalData.Entity.PhysicalData;
import com.example.Models.Product.Entity.Product;
import com.example.Operations.Checker;

public class Accessories extends Product {

    protected String color;
    protected String material;
    protected PhysicalData physicalData;
    
    protected Accessories() throws BuildException {
    }


    public static Accessories getInstance(String name, String description, double price, int stockQuantity,
    double rating, String brand, String color, String material, double high, double width, double length, 
    double weight, boolean fragile) throws BuildException{

        String message = "";

        Accessories a = new Accessories();

        try {
            a.checkData(name, description, price, stockQuantity, rating, brand);
        } catch (BuildException e) {
            message = e.getMessage();
        }

        int resultMaterial = a.setMaterial(material);
        if (resultMaterial != 0) {
            message += "El material no es correcto porque " + Checker.getErrorMessage(resultMaterial, 3, 50);
        }

        int resultColor = a.setColor(color);
        if (resultColor != 0) {
            message += "El color no es correcto porque " + Checker.getErrorMessage(resultColor, 3, 32);
        }
    

        try {
            a.physicalData = PhysicalData.getInstance(high, width, length, weight, fragile);
        } catch (BuildException ex) {
            message += ex.getMessage();
        }

        if (message.length() > 0) {
            a = null;
            throw new BuildException(message);
        }

        return a;

    }
    
    
    public String getColor() {
        return color;
    }

    public int setColor(String color) {
        if ((Checker.isNull(color)) != 0)
            return -1;
        if ((Checker.minLength(3, color)) != 0)
            return -2;
        if ((Checker.maxLenght(32, color)) != 0)
            return -10;
        this.color = color;
        return 0;
    }

    public String getMaterial() {
        return material;
    }

    public int setMaterial(String material) {
        if ((Checker.isNull(material)) != 0)
            return -1;
        if ((Checker.minLength(3, material)) != 0)
            return -2;
        if ((Checker.maxLenght(50, material)) != 0)
            return -10;
        this.material = material;
        return 0;
    }


}
