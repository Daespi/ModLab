package com.example.Models.Ventilation.Entity;

import com.example.Exceptions.BuildException;
import com.example.Models.PhysicalData.Entity.PhysicalData;
import com.example.Models.Product.Entity.Product;
import com.example.Models.RAM.Entity.Ram;
import com.example.Operations.Checker;

public class Ventilation extends Product{

    protected boolean leds;
    protected String color;
    protected int maxAirflow;
    protected int rotationSpeed;
    protected int noiseLevel;         // Nivel de ruido en decibelios (dB)
    protected String bearingType;     // Tipo de rodamientos (ej. "Ball Bearing")
    protected int inputVoltage;       // Voltaje de entrada (ej. 12V, 5V)
    protected PhysicalData physicalData;

    protected Ventilation() throws BuildException {
        
    }


    public static Ventilation getInstance(String name, String description, double price, int stockQuantity,
    double rating, String brand, boolean leds, String color, int maxAirflow, int rotationSpeed, 
    int noiseLevel, String bearingType, int inputVoltage, double high, double width, double length, double weight, boolean fragile) throws BuildException{

        String message = "";

        Ventilation fan = new Ventilation();

        try {
            fan.checkData(name, description, price, stockQuantity, rating, brand);
        } catch (BuildException e) {
            message = e.getMessage();
        }

        int resultColor = fan.setColor(color);
        if (resultColor != 0) {
            message += "El color no es correcto porque " + Checker.getErrorMessage(resultColor, 0, 1.20);
        }

        int resultMaxAirflow = fan.setMaxAirflow(maxAirflow);
        if (resultMaxAirflow != 0) {
            message += "El flujo de aire máximo no es correcto porque " + Checker.getErrorMessage(resultMaxAirflow, 0, 1.20);
        }

        int resultRotationSpeed = fan.setRotationSpeed(rotationSpeed);
        if (resultRotationSpeed != 0) {
            message += "La velocidad de rotación no es correcta porque " + Checker.getErrorMessage(resultRotationSpeed, 0, 1.20);
        }

        int resultNoiseLevel = fan.setNoiseLevel(noiseLevel);
        if (resultNoiseLevel != 0) {
            message += "El nivel de ruido no es correcto porque " + Checker.getErrorMessage(resultNoiseLevel, 0, 1.20);
        }

        int resultBearingType = fan.setBearingType(bearingType);
        if (resultBearingType != 0) {
            message += "El tipo de rodamientos no es correcto porque " + Checker.getErrorMessage(resultBearingType, 0, 1.20);
        }

        int resultInputVoltage = fan.setInputVoltage(inputVoltage);
        if (resultInputVoltage != 0) {
            message += "El voltaje de entrada no es correcto porque " + Checker.getErrorMessage(resultInputVoltage, 0, 1.20);
        }


        try {
            fan.physicalData = PhysicalData.getInstance(high, width, length, weight, fragile);
        } catch (BuildException ex) {
            message += ex.getMessage();
        }

        if (message.length() > 0) {
            fan = null;
            throw new BuildException(message);
        }

        return fan;

    }


    public boolean isLeds() {
        return leds;
    }


    public void setLeds(boolean leds) {
        this.leds = leds;
    }


    public String getColor() {
        return color;
    }


    public void setColor(String color) {
        this.color = color;
    }


    public int getMaxAirflow() {
        return maxAirflow;
    }


    public void setMaxAirflow(int maxAirflow) {
        this.maxAirflow = maxAirflow;
    }


    public int getRotationSpeed() {
        return rotationSpeed;
    }


    public void setRotationSpeed(int rotationSpeed) {
        this.rotationSpeed = rotationSpeed;
    }

    public int getNoiseLevel() {
        return noiseLevel;
    }


    public void setNoiseLevel(int noiseLevel) {
        this.noiseLevel = noiseLevel;
    }


    public String getBearingType() {
        return bearingType;
    }


    public void setBearingType(String bearingType) {
        this.bearingType = bearingType;
    }


    public int getInputVoltage() {
        return inputVoltage;
    }


    public void setInputVoltage(int inputVoltage) {
        this.inputVoltage = inputVoltage;
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
