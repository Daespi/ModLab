package com.example.Models.HardDrive.Entity;

import com.example.Exceptions.BuildException;
import com.example.Models.PhysicalData.Entity.PhysicalData;
import com.example.Models.PlacaBase.Entity.Motherboard;
import com.example.Models.Product.Entity.Product;
import com.example.Operations.Checker;

public class HardDrive extends Product {

    protected String storageInterface;
    protected boolean ssd;
    protected int randomReading;
    protected int capacity;
    protected int writeSpeed;
    protected String formFactor;
    protected PhysicalData physicalData;

    protected HardDrive() throws BuildException {
    }

    public static HardDrive getInstance(String name, String description, double price, int stockQuantity,
    double rating, String brand, String storageInterface, String typeOfStorage, int randomReading, int capacity, int writeSpeed, String formFactor, double high, double width, double length, double weight, 
    boolean fragile) throws BuildException {

        String message = "";

        HardDrive hd = new HardDrive();

        try {
            hd.checkData(name, description, price, stockQuantity, rating, brand);
        } catch (BuildException e) {
            message = e.getMessage();
        }

        int resultStorageInterface = hd.setStorageInterface(storageInterface);
        if (resultStorageInterface != 0) {
            message += "La interfaz de almacenamiento no es correcta porque " + Checker.getErrorMessage(resultStorageInterface, 2, 50);
        }

        int resultRandomReading = hd.setRandomReading(randomReading);
        if (resultRandomReading != 0) {
            message += "La lectura aleatoria no es correcta porque " + Checker.getErrorMessage(resultRandomReading, 0, 1.20);
        }
        
        int resultCapacity = hd.setCapacity(capacity);
        if (resultCapacity != 0) {
            message += "La capacidad no es correcta porque " + Checker.getErrorMessage(resultCapacity, 0, 1.20);
        }
        
        int resultWriteSpeed = hd.setWriteSpeed(writeSpeed);
        if (resultWriteSpeed != 0) {
            message += "La velocidad de escritura no es correcta porque " + Checker.getErrorMessage(resultWriteSpeed, 0, 1.20);
        }
        
        int resultFormFactor = hd.setFormFactor(formFactor);
        if (resultFormFactor != 0) {
            message += "El formato físico (form factor) no es correcto porque " + Checker.getErrorMessage(resultFormFactor, 0, 1.20);
        }
        
        try {
            hd.physicalData = PhysicalData.getInstance(high, width, length, weight, fragile);
        } catch (BuildException ex) {
            message += ex.getMessage();
        }

        if (message.length() > 0) {
            hd = null;
            throw new BuildException(message);
        }
        return hd;
    }

    
    
     public String getStorageInterface() {
        return storageInterface;
    }

    public int setStorageInterface(String storageInterface) {
        if ((Checker.isNull(storageInterface)) != 0)
            return -1;
        if ((Checker.minLength(2, storageInterface)) != 0)
            return -2;
        if ((Checker.maxLenght(50, storageInterface)) != 0)
            return -10;
        this.storageInterface = storageInterface;
        return 0;
    }

    public boolean isSsd() {
        return ssd;
    }

    public int getRandomReading() {
        return randomReading;
    }

    public int setRandomReading(int randomReading) {
        if (Checker.nonZero(randomReading) != 0) {
            return -3;
        }

        if (Checker.nonNegative(randomReading) != 0) {
            return -4;
        }

        if (Checker.maxValue(randomReading, 1000000) != 0) {
            return -5;
        }

        if (Checker.minValue(randomReading, 80) != 0) {
            return -7;
        }
        this.randomReading = randomReading;
        return 0;
    }

    public int getCapacity() {
        return capacity;
    }

    public int setCapacity(int capacity) {
        this.capacity = capacity;
        return 0;
    }

    public int getWriteSpeed() {
        return writeSpeed;
    }

    public int setWriteSpeed(int writeSpeed) {
        this.writeSpeed = writeSpeed;
        return 0;
    }

    public String getFormFactor() {
        return formFactor;
    }

    public int setFormFactor(String formFactor) {
        this.formFactor = formFactor;
        return 0;
    }

    
    // ---------------


     public double getWidth() {
        return physicalData.getWidth();
    }

    public double getHigh() {
        return physicalData.getHigh();
    }

    public double getLength() {
        return physicalData.getLength();
    }

    public double getWeight() {
        return physicalData.getWeight();
    }

    public Boolean getFragile() {
        return physicalData.getFragile();
    }

    public int setWidth(double width) {
        return physicalData.setWidth(width);
    }

    public int setLength(double length) {
        return physicalData.setLength(length);
    }

    public int setHigh(double high) {
        return physicalData.setHigh(high);
    }

    public int setWeight(double weight) {
        return physicalData.setWeight(weight);
    }

    public int setFragil(Boolean fragile) {
        return physicalData.setFragile(fragile);
    }


    public double getVolume() {
        return physicalData.getVolume();
    }




}
