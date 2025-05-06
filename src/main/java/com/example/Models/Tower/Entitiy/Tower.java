 package com.example.Models.Tower.Entitiy;

import java.util.Set;

import com.example.Exceptions.BuildException;
import com.example.Models.PhysicalData.Entity.PhysicalData;
import com.example.Models.Product.Entity.Product;
import com.example.Models.Ventilation.Entity.Ventilation;
import com.example.Operations.Checker;

public class Tower extends Product {

    protected String formFactor;
    protected String color;
    protected Set<String> connectors;
    protected String material;
    protected int fanSupport;
    protected int maxGpuLength;
    protected int maxCpuCoolerHeight;
    protected PhysicalData physicalData;

    protected Tower() throws BuildException {
    }

    public static Tower getInstance(String name, String description, double price, int stockQuantity,
    double rating, String brand, String formFactor, String color, String connectors, String material, 
    int fanSupport, int maxGpuLength, int maxCpuCoolerHeight, double high, double width, double length, 
    double weight, boolean fragile) throws BuildException{


        String message = "";

        Tower tower = new Tower();

        try {
            tower.checkData(name, description, price, stockQuantity, rating, brand);
        } catch (BuildException e) {
            message = e.getMessage();
        }

        int resultFormFactor = tower.setFormFactor(formFactor);
        if (resultFormFactor != 0) {
            message += "El factor de forma no es correcto porque " + Checker.getErrorMessage(resultFormFactor, 0, 1.20);
        }

        int resultColor = tower.setColor(color);
        if (resultColor != 0) {
            message += "El color no es correcto porque " + Checker.getErrorMessage(resultColor, 0, 1.20);
        }

        int resultConnectors = tower.setConnectors(connectors);
        if (resultConnectors != 0) {
            message += "Los conectores no son correctos porque " + Checker.getErrorMessage(resultConnectors, 0, 1.20);
        }

        int resultMaterial = tower.setMaterial(material);
        if (resultMaterial != 0) {
            message += "El material no es correcto porque " + Checker.getErrorMessage(resultMaterial, 0, 1.20);
        }

        int resultFanSupport = tower.setFanSupport(fanSupport);
        if (resultFanSupport != 0) {
            message += "El soporte para ventiladores no es correcto porque " + Checker.getErrorMessage(resultFanSupport, 0, 1.20);
        }

        int resultMaxGpuLength = tower.setMaxGpuLength(maxGpuLength);
        if (resultMaxGpuLength != 0) {
            message += "La longitud máxima de GPU no es correcta porque " + Checker.getErrorMessage(resultMaxGpuLength, 0, 1.20);
        }

        int resultMaxCpuCoolerHeight = tower.setMaxCpuCoolerHeight(maxCpuCoolerHeight);
        if (resultMaxCpuCoolerHeight != 0) {
            message += "La altura máxima del disipador de CPU no es correcta porque " + Checker.getErrorMessage(resultMaxCpuCoolerHeight, 0, 1.20);
        }

        try {
            tower.physicalData = PhysicalData.getInstance(high, width, length, weight, fragile);
        } catch (BuildException ex) {
            message += ex.getMessage();
        }

        if (message.length() > 0) {
            tower = null;
            throw new BuildException(message);
        }

        return tower;

    }

    public String getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(String formFactor) {
        this.formFactor = formFactor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Set<String> getConnectors() {
        return connectors;
    }

    public void setConnectors(Set<String> connectors) {
        this.connectors = connectors;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getFanSupport() {
        return fanSupport;
    }

    public void setFanSupport(int fanSupport) {
        this.fanSupport = fanSupport;
    }

    public int getMaxGpuLength() {
        return maxGpuLength;
    }

    public void setMaxGpuLength(int maxGpuLength) {
        this.maxGpuLength = maxGpuLength;
    }

    public int getMaxCpuCoolerHeight() {
        return maxCpuCoolerHeight;
    }

    public void setMaxCpuCoolerHeight(int maxCpuCoolerHeight) {
        this.maxCpuCoolerHeight = maxCpuCoolerHeight;
    }


    //-------------------------------------------------------

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
