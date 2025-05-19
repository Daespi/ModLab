
package com.example.Models.CPU.Entity;

import com.example.Exceptions.BuildException;
import com.example.Models.PhysicalData.Entity.PhysicalData;
import com.example.Models.Product.Entity.Product;
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
    protected String model;

    protected CPU() throws BuildException {}

    public static CPU getInstance(String name, String description, double price, int stockQuantity,
                                  double rating, String brand, String model, int processorCore, int numberThreads,
                                  double baseClock, double frecuency, String cacheMemory, int tdp, String socket,
                                  int lithography, boolean hasIntegratedGraphics, double high, double width,
                                  double length, double weight, boolean fragile) throws BuildException {

        String message = "";
        CPU cpu = new CPU();

        try {
            cpu.checkData(name, description, price, stockQuantity, rating, brand);
        } catch (BuildException e) {
            message = e.getMessage();
        }

        int resultProcessorCore = cpu.setProcessorCore(processorCore);
        if (resultProcessorCore != 0)
            message += "El número de núcleos no es correcto porque " + Checker.getErrorMessage(resultProcessorCore, 4, 24);

        int resultNumberThreads = cpu.setNumberThreads(numberThreads);
        if (resultNumberThreads != 0)
            message += "El número de hilos no es correcto porque " + Checker.getErrorMessage(resultNumberThreads, 2, 32);

        int resultBaseClock = cpu.setBaseClock(baseClock);
        if (resultBaseClock != 0)
            message += "La frecuencia base no es correcta porque " + Checker.getErrorMessage(resultBaseClock, 1.0, 4.7);

        int resultFrecuency = cpu.setFrecuency(frecuency);
        if (resultFrecuency != 0)
            message += "La frecuencia máxima no es correcta porque " + Checker.getErrorMessage(resultFrecuency, 0.8, 5.0);

        int resultCacheMemory = cpu.setCacheMemory(cacheMemory);
        if (resultCacheMemory != 0)
            message += "La memoria caché no es correcta porque " + Checker.getErrorMessage(resultCacheMemory, 5, 150);

        int resultTdp = cpu.setTdp(tdp);
        if (resultTdp != 0)
            message += "El TDP no es correcto porque " + Checker.getErrorMessage(resultTdp, 35, 170);

        int resultSocket = cpu.setSocket(socket);
        if (resultSocket != 0)
            message += "El socket no es correcto porque " + Checker.getErrorMessage(resultSocket, 2, 50);

        int resultLithography = cpu.setLithography(lithography);
        if (resultLithography != 0)
            message += "La litografía no es correcta porque " + Checker.getErrorMessage(resultLithography, 4, 14);

        int resultModel = cpu.setModel(model);
        if (resultModel != 0)
            message += "El modelo no es correcto porque " + Checker.getErrorMessage(resultModel, 2, 50);

        try {
            cpu.physicalData = PhysicalData.getInstance(high, width, length, weight, fragile);
        } catch (BuildException ex) {
            message += ex.getMessage();
        }

        if (!message.isEmpty()) throw new BuildException(message);
        return cpu;
    }

    public int getProcessorCore() { return processorCore; }
    public int setProcessorCore(int val) {
        if (Checker.nonZero(val) != 0 || Checker.nonNegative(val) != 0 ||
            Checker.minValue(val, 4) != 0 || Checker.maxValue(val, 24) != 0) return -1;
        processorCore = val; return 0;
    }

    public int getNumberThreads() { return numberThreads; }
    public int setNumberThreads(int val) {
        if (Checker.nonZero(val) != 0 || Checker.nonNegative(val) != 0 ||
            Checker.minValue(val, 2) != 0 || Checker.maxValue(val, 32) != 0) return -1;
        numberThreads = val; return 0;
    }

    public double getBaseClock() { return baseClock; }
    public int setBaseClock(double val) {
        if (Checker.nonZero(val) != 0 || Checker.nonNegative(val) != 0 ||
            Checker.minValue(val, 1.0) != 0 || Checker.maxValue(val, 4.7) != 0) return -1;
        baseClock = val; return 0;
    }

    public double getFrecuency() { return frecuency; }
    public int setFrecuency(double val) {
        if (Checker.nonZero(val) != 0 || Checker.nonNegative(val) != 0 ||
            Checker.minValue(val, 0.8) != 0 || Checker.maxValue(val, 5.0) != 0) return -1;
        frecuency = val; return 0;
    }

    public String getCacheMemory() { return cacheMemory; }
    public int setCacheMemory(String val) {
        if (Checker.isNull(val) != 0 || Checker.minLength(5, val) != 0 || Checker.maxLenght(150, val) != 0) return -1;
        cacheMemory = val; return 0;
    }

    public int getTdp() { return tdp; }
    public int setTdp(int val) {
        if (Checker.nonZero(val) != 0 || Checker.nonNegative(val) != 0 ||
            Checker.minValue(val, 35) != 0 || Checker.maxValue(val, 170) != 0) return -1;
        tdp = val; return 0;
    }

    public String getSocket() { return socket; }
    public int setSocket(String val) {
        if (Checker.isNull(val) != 0 || Checker.minLength(2, val) != 0 || Checker.maxLenght(50, val) != 0) return -1;
        socket = val; return 0;
    }

    public int getLithography() { return lithography; }
    public int setLithography(int val) {
        if (Checker.nonZero(val) != 0 || Checker.nonNegative(val) != 0 ||
            Checker.minValue(val, 4) != 0 || Checker.maxValue(val, 14) != 0) return -1;
        lithography = val; return 0;
    }

    public boolean isHasIntegratedGraphics() { return hasIntegratedGraphics; }
    public int setHasIntegratedGraphics(boolean val) { hasIntegratedGraphics = val; return 0; }

    public String getModel() { return model; }
    public int setModel(String val) {
        if (Checker.isNull(val) != 0 || Checker.minLength(2, val) != 0 || Checker.maxLenght(50, val) != 0) return -1;
        model = val; return 0;
    }

    public double getWidth() { return physicalData.getWidth(); }
    public double getHigh() { return physicalData.getHigh(); }
    public double getLength() { return physicalData.getLength(); }
    public double getWeight() { return physicalData.getWeight(); }
    public boolean getFragile() { return physicalData.getFragile(); }

    public int setWidth(double val) { return physicalData.setWidth(val); }
    public int setLength(double val) { return physicalData.setLength(val); }
    public int setHigh(double val) { return physicalData.setHigh(val); }
    public int setWeight(double val) { return physicalData.setWeight(val); }
    public int setFragil(boolean val) { return physicalData.setFragile(val); }

    public double getVolume() { return physicalData.getVolume(); }
}
