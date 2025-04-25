package com.example.Models.RAM.Entity;

import com.example.Exceptions.BuildException;
import com.example.Models.PhysicalData.Entity.PhysicalData;
import com.example.Models.Product.Entity.Product;
import com.example.Operations.Checker;

public class Ram extends Product {

    protected int latency;
    protected String typeDdr;
    protected String internalMemory;
    protected String memorySpeed;
    protected Boolean led;
    protected PhysicalData physicalData;

    protected Ram() throws BuildException {
    }

    public static Ram getInstance(int latency, String typeDdr, String internalMemory, String memorySpeed, 
                                  Double high, Double width, Double length, Double weight, boolean fragile) throws BuildException {

        String message = "";

        Ram ram = new Ram();

        int resultLatency = ram.setLatency(latency);
        if (resultLatency != 0) {
            message += "Esta latencia no es correcta porque " + Checker.getErrorMessage(resultLatency, 0, 1.20);
        }

        int resultTypeDdr = ram.setTypeDdr(typeDdr);
        if (resultTypeDdr != 0) {
            message += "Este tipo de ddr no es correcto porque " + Checker.getErrorMessage(resultTypeDdr, 0, 1.20);
        }

        int resultInternalMemory = ram.setInternalMemory(internalMemory);
        if (resultInternalMemory != 0) {
            message += "Esta memoria interna no es correcta porque " + Checker.getErrorMessage(resultInternalMemory, 0, 1.20);
        }

        int resultMemorySpeed = ram.setMemorySpeed(memorySpeed);
        if (resultMemorySpeed != 0) {
            message += "Esta velocidad de memoria no es correcta porque " + Checker.getErrorMessage(resultMemorySpeed, 0, 1.20);
        }

        try {
            ram.physicalData = PhysicalData.getInstance(high, width, length, weight, fragile);
        } catch (BuildException ex) {
            message += ex.getMessage();
        }

        if (message.length() > 0) {
            ram = null;
            throw new BuildException(message);
        }

        return ram;
    }

    public int getLatency() {
        return latency;
    }

    public int setLatency(int latency) {
        if ((Checker.nonZero(latency)) != 0)
            return -1;
        if (Checker.nonNegative(latency) != 0) {
            return -4;
        }
        if ((Checker.minValue(10, latency)) != 0)
            return -7;
        if ((Checker.maxValue(32, latency)) != 0)
            return -5;
        this.latency = latency;
        return 0;
    }

    public String getTypeDdr() {
        return typeDdr;
    }

    public int setTypeDdr(String typeDdr) {
        if ((Checker.isNull(typeDdr)) != 0)
            return -1;
        if ((Checker.minLength(3, typeDdr)) != 0)
            return -2;
        if ((Checker.maxLenght(15, typeDdr)) != 0)
            return -10;
        this.typeDdr = typeDdr;
        return 0;
    }

    // Getter and Setter methods for internalMemory
    public String getInternalMemory() {
        return internalMemory;
    }

    public int setInternalMemory(String internalMemory) {
        if ((Checker.isNull(internalMemory)) != 0)
            return -1;
        if ((Checker.minLength(2, internalMemory)) != 0)
            return -2;
        if ((Checker.maxLenght(10, internalMemory)) != 0)
            return -10;
        this.internalMemory = internalMemory;
        return 0;
    }

    // Getter and Setter methods for memorySpeed
    public String getMemorySpeed() {
        return memorySpeed;
    }

    public int setMemorySpeed(String memorySpeed) {
        if ((Checker.isNull(memorySpeed)) != 0)
            return -1;
        if ((Checker.minLength(8, memorySpeed)) != 0)
            return -2;
        if ((Checker.maxLenght(32, memorySpeed)) != 0)
            return -10;
        this.memorySpeed = memorySpeed;
        return 0;
    }

    public int setLed(boolean led) {
        this.led = led;
        return 0;
    }

    // Getter for physicalData
    public PhysicalData getPhysicalData() {
        return physicalData;
    }

    public void setPhysicalData(PhysicalData physicalData) {
        this.physicalData = physicalData;
    }

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
