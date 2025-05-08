package com.example.Models.CPU.Entity;

import com.example.Exceptions.BuildException;
import com.example.Models.PhysicalData.Entity.PhysicalData;
import com.example.Models.Product.Entity.Product;
import com.example.Models.Ram.Entity.Ram;
import com.example.Operations.Checker;

public class CPU extends Product {

    protected int processorCore;
    protected int numberThreads;
    protected double baseClock;
    protected double frecuency;
    protected String cacheMemory;
    protected int tdp;
    protected String socket;
    protected int lithography;
    protected boolean hasIntegratedGraphics;
    protected PhysicalData physicalData;

    protected CPU() throws BuildException {
    }

    public static CPU getInstance(String name, String description, double price, int stockQuantity,
            double rating, String brand, String model, int processorCore, int numberThreads, double baseClock,
            double frecuency, String cacheMemory, int tdp, String socket, int lithography,
            boolean hasIntegratedGraphics, double high, double width, double length,
            double weight, boolean fragile) throws BuildException {

        String message = "";

        CPU cpu = new CPU();

        try {
            cpu.checkData(name, description, price, stockQuantity, rating, brand);
        } catch (BuildException e) {
            message = e.getMessage();
        }

        int resultProcessorCore = cpu.setProcessorCore(processorCore);
        if (resultProcessorCore != 0) {
            message += "El número de núcleos no es correcto porque "
                    + Checker.getErrorMessage(resultProcessorCore, 4, 24);
        }
        int resultNumberThreads = cpu.setNumberThreads(numberThreads);
        if (resultNumberThreads != 0) {
            message += "El número de hilos no es correcto porque "
                    + Checker.getErrorMessage(resultNumberThreads, 2, 32);
        }
        int resultBaseClock = cpu.setBaseClock(baseClock);
        if (resultBaseClock != 0) {
            message += "La frecuencia base no es correcta porque " + Checker.getErrorMessage(resultBaseClock, 1.0, 4.7);
        }
        int resultFrecuency = cpu.setFrecuency(frecuency);
        if (resultFrecuency != 0) {
            message += "La frecuencia máxima no es correcta porque "
                    + Checker.getErrorMessage(resultFrecuency, 8.0, 5.0);
        }
        int resultCacheMemory = cpu.setCacheMemory(cacheMemory);
        if (resultCacheMemory != 0) {
            message += "La memoria caché no es correcta porque " + Checker.getErrorMessage(resultCacheMemory, 5, 150);
        }
        int resultTdp = cpu.setTdp(tdp);
        if (resultTdp != 0) {
            message += "El TDP no es correcto porque " + Checker.getErrorMessage(resultTdp, 35, 170);
        }
        int resultSocket = cpu.setSocket(socket);
        if (resultSocket != 0) {
            message += "El socket no es correcto porque " + Checker.getErrorMessage(resultSocket, 2, 50);
        }
        int resultLithography = cpu.setLithography(lithography);
        if (resultLithography != 0) {
            message += "La litografía no es correcta porque " + Checker.getErrorMessage(resultLithography, 4, 14);
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

    public int setProcessorCore(int processorCore) {
        if (Checker.nonZero(processorCore) != 0) {
            return -3;
        }
        if (Checker.nonNegative(processorCore) != 0) {
            return -4;
        }
        if (Checker.minValue(processorCore, 4) != 0) {
            return -7;
        }
        if (Checker.maxValue(processorCore, 24) != 0) {
            return -5;
        }
        this.processorCore = processorCore;
        return 0;
    }

    public int getNumberThreads() {
        return numberThreads;
    }

    public int setNumberThreads(int numberThreads) {
        if (Checker.nonZero(numberThreads) != 0) {
            return -3;
        }
        if (Checker.nonNegative(numberThreads) != 0) {
            return -4;
        }
        if (Checker.minValue(numberThreads, 2) != 0) {
            return -7;
        }
        if (Checker.maxValue(numberThreads, 32) != 0) {
            return -5;
        }
        this.numberThreads = numberThreads;
        return 0;
    }

    public double getBaseClock() {
        return baseClock;
    }

    public int setBaseClock(double baseClock) {
        if (Checker.nonZero(baseClock) != 0) {
            return -3;
        }
        if (Checker.nonNegative(baseClock) != 0) {
            return -4;
        }
        if (Checker.minValue(baseClock, 1.0) != 0) {
            return -7;
        }
        if (Checker.maxValue(baseClock, 4.7) != 0) {
            return -5;
        }
        this.baseClock = baseClock;
        return 0;
    }

    public double getFrecuency() {
        return frecuency;
    }

    public int setFrecuency(double frecuency) {
        if (Checker.nonZero(frecuency) != 0) {
            return -3;
        }
        if (Checker.nonNegative(frecuency) != 0) {
            return -4;
        }
        if (Checker.maxValue(frecuency, 5.0) != 0) {
            return -5;
        }
        if (Checker.minValue(frecuency, 0.8) != 0) {
            return -7;
        }
        this.frecuency = frecuency;
        return 0;
    }

    public String getCacheMemory() {
        return cacheMemory;
    }

    public int setCacheMemory(String cacheMemory) {
        if ((Checker.isNull(cacheMemory)) != 0)
            return -1;
        if ((Checker.minLength(5, cacheMemory)) != 0)
            return -2;
        if ((Checker.maxLenght(150, cacheMemory)) != 0)
            return -10;
        this.cacheMemory = cacheMemory;
        return 0;
    }

    public int getTdp() {
        return tdp;
    }

    public int setTdp(int tdp) {
        if (Checker.nonZero(tdp) != 0) {
            return -3;
        }
        if (Checker.nonNegative(tdp) != 0) {
            return -4;
        }
        if (Checker.maxValue(tdp, 170) != 0) {
            return -5;
        }
        if (Checker.minValue(tdp, 35) != 0) {
            return -7;
        }
        this.tdp = tdp;
        return 0;
    }

    public String getSocket() {
        return socket;
    }

    public int setSocket(String socket) {
        if ((Checker.isNull(socket)) != 0)
            return -1;
        if ((Checker.minLength(2, socket)) != 0)
            return -2;
        if ((Checker.maxLenght(50, socket)) != 0)
            return -10;
        this.socket = socket;
        return 0;
    }

    public int getLithography() {
        return lithography;
    }

    public int setLithography(int lithography) {
        if (Checker.nonZero(lithography) != 0) {
            return -3;
        }
        if (Checker.nonNegative(lithography) != 0) {
            return -4;
        }
        if (Checker.maxValue(lithography, 14) != 0) {
            return -5;
        }
        if (Checker.minValue(lithography, 4) != 0) {
            return -7;
        }
        this.lithography = lithography;
        return 0;
    }

    public boolean isHasIntegratedGraphics() {
        return hasIntegratedGraphics;
    }

    public int setHasIntegratedGraphics(boolean hasIntegratedGraphics) {
        this.hasIntegratedGraphics = hasIntegratedGraphics;
        return 0;
    }

    // ---------------------------------------------

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