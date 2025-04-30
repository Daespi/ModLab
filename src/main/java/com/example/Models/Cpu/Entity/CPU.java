package com.example.Models.Cpu.Entity;

import com.example.Exceptions.BuildException;
import com.example.Models.PhysicalData.Entity.PhysicalData;
import com.example.Models.Product.Entity.Product;
import com.example.Models.RAM.Entity.Ram;

public class CPU extends Product{

    protected int processorCore;
    protected int numberThreads;
    protected double baseClock;
    protected double frecuency;
    protected int cacheMemory;
    protected int tdp;
    protected PhysicalData physicalData;

    protected CPU() throws BuildException {
    }

    public static CPU getInstance(String name, String description, double price, int stockQuantity,
    double rating, String brand, String model, int processorCore, int numberThreads, double baseClock, 
    double frecuency, int cacheMemory, int tdp, double high, double width, double length, 
    double weight, boolean fragile) throws BuildException{

        String message = "";

        CPU cpu = new CPU();

        try {
            cpu.checkData(name, description, price, stockQuantity, rating, brand);
        } catch (BuildException e) {
            message = e.getMessage();
        }

        try {
            cpu.physicalData = PhysicalData.getInstance(high, width, length, weight, fragile);
        } catch (BuildException ex) {
            message += ex.getMessage();
        }

        if (message.length() > 0) {
            cpu = null;
            throw new BuildException(message);
        }

        return cpu;

    }

    public int getProcessorCore() {
        return processorCore;
    }

    public void setProcessorCore(int processorCore) {
        this.processorCore = processorCore;
    }

    public int getNumberThreads() {
        return numberThreads;
    }

    public void setNumberThreads(int numberThreads) {
        this.numberThreads = numberThreads;
    }

    public double getBaseClock() {
        return baseClock;
    }

    public void setBaseClock(double baseClock) {
        this.baseClock = baseClock;
    }

    public double getFrecuency() {
        return frecuency;
    }

    public void setFrecuency(double frecuency) {
        this.frecuency = frecuency;
    }

    public int getCacheMemory() {
        return cacheMemory;
    }

    public void setCacheMemory(int cacheMemory) {
        this.cacheMemory = cacheMemory;
    }

    public int getTdp() {
        return tdp;
    }

    public void setTdp(int tdp) {
        this.tdp = tdp;
    }

    //---------------------------------------------

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

    // Setters for physical properties
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

    // Method to calculate volume
    public double getVolume() {
        return physicalData.getVolume();
    }

    

}
