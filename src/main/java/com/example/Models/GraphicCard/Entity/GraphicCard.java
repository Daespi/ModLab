package com.example.Models.GraphicCard.Entity;

import com.example.Exceptions.BuildException;
import com.example.Models.PhysicalData.Entity.PhysicalData;
import com.example.Models.Product.Entity.Product;
import com.example.Operations.Checker;

public class GraphicCard extends Product{

    
    protected String colour;
    protected int memory;
    protected String memoryType;
    protected String gpu;
    protected int recommendedPowerSupply;
    protected PhysicalData physicalData;

    protected GraphicCard() throws BuildException {
    }

    public static GraphicCard getInstance(String name, String description, double price, int stockQuantity,
    double rating, /*String imageUrl,*/ String brand, String colour, int memory, String memoryType, String gpu, 
    int recommendedPowerSupply, double high, double width, double length, double weight, boolean fragile) throws BuildException {

        String message = "";
        GraphicCard gc = new GraphicCard();

        try {
            gc.checkData(name, description, price, stockQuantity, rating, brand);
        } catch (BuildException e) {
            message = e.getMessage();
        }

        int resultColour = gc.setColour(colour);
        if (resultColour != 0) {
            message += "El color no es correcto porque " + Checker.getErrorMessage(resultColour, 0, 1.20);
        }

        int resultMemory = gc.setMemory(memory);
        if (resultMemory != 0) {
            message += "La memoria no es correcta porque " + Checker.getErrorMessage(resultMemory, 0, 1.20);
        }

        int resultMemoryType = gc.setMemoryType(memoryType);
        if (resultMemoryType != 0) {
            message += "El tipo de memoria no es correcto porque " + Checker.getErrorMessage(resultMemoryType, 0, 1.20);
        }

        int resultGpu = gc.setGpu(gpu);
        if (resultGpu != 0) {
            message += "El GPU no es correcto porque " + Checker.getErrorMessage(resultGpu, 0, 1.20);
        }

        int resultPower = gc.setRecommendedPowerSupply(recommendedPowerSupply);
        if (resultPower != 0) {
            message += "La fuente de poder recomendada no es correcta porque " + Checker.getErrorMessage(resultPower, 0, 1.20);
        }

        try {
            gc.physicalData = PhysicalData.getInstance(high, width, length, weight, fragile);
        } catch (BuildException ex) {
            message += ex.getMessage();
        }

        if (!message.isEmpty()) {
            gc = null;
            throw new BuildException(message);
        }

        return gc;
    }

    public String getColour() {
        return colour;
    }

    public int setColour(String colour) {
        if ((Checker.isNull(colour)) != 0)
            return -1;
        this.colour = colour;
        return 0;
    }

    public int getMemory() {
        return memory;
    }

    public int setMemory(int memory) {
        if ((Checker.nonZero(memory)) != 0)
            return -3;
        if (Checker.nonNegative(memory) != 0) {
            return -4;
        }
        this.memory = memory;
        return 0;
    }

    public String getMemoryType() {
        return memoryType;
    }

    public int setMemoryType(String memoryType) {
        if ((Checker.isNull(memoryType)) != 0)
            return -1;
        this.memoryType = memoryType;
        return 0;
    }

    public String getGpu() {
        return gpu;
    }

    public int setGpu(String gpu) {
        if ((Checker.isNull(gpu)) != 0)
            return -1;
        this.gpu = gpu;
        return 0;
    }

    public int getRecommendedPowerSupply() {
        return recommendedPowerSupply;
    }

    public int setRecommendedPowerSupply(int recommendedPowerSupply) {
        if ((Checker.nonZero(recommendedPowerSupply)) != 0)
            return -3;
        if (Checker.nonNegative(recommendedPowerSupply) != 0) {
            return -4;
        }
        this.recommendedPowerSupply = recommendedPowerSupply;
        return 0;
    }

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
