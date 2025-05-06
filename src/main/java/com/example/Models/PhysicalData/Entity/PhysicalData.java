package com.example.Models.PhysicalData.Entity;

import com.example.Exceptions.BuildException;
import com.example.Operations.Checker;



public class PhysicalData {

     private Double high, width, length, weight;
    private boolean fragile;
    
    
    
    public PhysicalData(){};

    // Constructor
    public static PhysicalData getInstance(Double high, Double width, Double length, Double weight, boolean fragile) throws BuildException {
        String message = "";
        PhysicalData p = new PhysicalData();

        int resultHigh = p.setHigh(high);
        if (resultHigh != 0) {
            message += "High no es correcto porque" + Checker.getErrorMessage(resultHigh, 0, 1.20);
        }

        int resultWidth = p.setWidth(width);
        if (resultWidth != 0) {
            message += "Width no es correcto porque" + Checker.getErrorMessage(resultWidth, 0, 1.20);
        }

        int resultLength = p.setLength(length);
        if (resultLength != 0) {
            message += "Length no es correcto porque" + Checker.getErrorMessage(resultLength, 0, 1.20);
        }

        int resultWeight = p.setWeight(weight);
        if (resultWeight != 0) {
            message += "Weight no es correcto porque" + Checker.getErrorMessage(resultWeight, 0, 35.00);
        }

        p.setFragile(fragile);
        
        if (message.length() > 0) {
            p = null;
            throw new BuildException(message);
        }

        return p;
    }

    // Getters
    public Double getHigh() {
        return this.high;
    }

    public Double getWidth() {
        return this.width;
    }

    public Double getLength() {
        return this.length;
    }

    public Double getWeight() {
        return this.weight;
    }

    public boolean getFragile() {
        return this.fragile;
    }

    // Setters with simple validations
    public int setHigh(Double high) {
 
        if (Checker.nonZero(high) != 0) {
            return -3;
        }

        if (Checker.nonNegative(high) != 0) {
            return -4;
        }

        if (Checker.maxValue(high, 35.00) != 0) {
            return -5;
        }

        this.high = high;
        return 0;
    }

    public int setWidth(Double width) {

        if (Checker.nonZero(width) != 0) {
            return -3;
        }

        if (Checker.nonNegative(width) != 0) {
            return -4;
        }

        if (Checker.maxValue(width, 1.20) != 0) {
            return -5;
        }

        this.width = width;
        return 0;
    }

    public int setLength(Double length) {

        if (Checker.nonZero(length) != 0) {
            return -3;
        }

        if (Checker.nonNegative(length) != 0) {
            return -4;
        }

        if (Checker.maxValue(length, 1.20) != 0) {
            return -5;
        }

        this.length = length;
        return 0;
    }

    public int setWeight(Double weight) {
        
        if (Checker.nonZero(weight) != 0) {
            return -3;
        }

        if (Checker.nonNegative(weight) != 0) {
            return -4;
        }

        if (Checker.maxValue(weight, 35.00) != 0) {
            return -5;
        }

        this.weight = weight;
        return 0;
    }

    public int setFragile(boolean fragile) {
        this.fragile = fragile;
        return 0;
    }


    public int getVolume() {
        return (int) (this.high * this.width * this.length);
    }

    @Override
    public String toString() {
        return "PhysicalData [getHigh()=" + getHigh() + ", getWidth()=" + getWidth() + ", getLength()=" + getLength()
                + ", getWeight()=" + getWeight() + ", getFragile()=" + getFragile() + ", getVolume()=" + getVolume()
                + "]";
    }

    

    
    
}
