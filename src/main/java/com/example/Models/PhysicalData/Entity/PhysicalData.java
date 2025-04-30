package com.example.Models.PhysicalData.Entity;

import com.example.Exceptions.BuildException;
import com.example.Operations.Checker;



public class PhysicalData {

     private double high, width, length, weight;
    private boolean fragile;
    
    
    
    public PhysicalData(){};

    // Constructor
    public static PhysicalData getInstance(double high, double width, double length, double weight, boolean fragile) throws BuildException {
        String message = "";
        PhysicalData p = new PhysicalData();

        int resultHigh = p.setHigh(high);
        if (resultHigh != 0) {
            message += "Este alto no es correcto porque" + Checker.getErrorMessage(resultHigh, 0, 1.20);
        }

        int resultWidth = p.setWidth(width);
        if (resultWidth != 0) {
            message += "Este ancho no es correcto porque" + Checker.getErrorMessage(resultWidth, 0, 1.20);
        }

        int resultLength = p.setLength(length);
        if (resultLength != 0) {
            message += "Este largo no es correcto porque" + Checker.getErrorMessage(resultLength, 0, 1.20);
        }

        int resultWeight = p.setWeight(weight);
        if (resultWeight != 0) {
            message += "Este peso no es correcto porque" + Checker.getErrorMessage(resultWeight, 0, 35.00);
        }

        p.setFragile(fragile);
        
        if (message.length() > 0) {
            p = null;
            throw new BuildException(message);
        }

        return p;
    }

    // Getters
    public double getHigh() {
        return this.high;
    }

    public double getWidth() {
        return this.width;
    }

    public double getLength() {
        return this.length;
    }

    public double getWeight() {
        return this.weight;
    }

    public boolean getFragile() {
        return this.fragile;
    }

    // Setters with simple validations
    public int setHigh(double high) {
 
        if (Checker.nonZero(high) != 0) {
            return -3;
        }

        if (Checker.nonNegative(high) != 0) {
            return -4;
        }

        if (Checker.maxValue(high, 1.00) != 0) {
            return -5;
        }

        this.high = high;
        return 0;
    }

    public int setWidth(double width) {

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

    public int setLength(double length) {

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

    public int setWeight(double weight) {
        
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
