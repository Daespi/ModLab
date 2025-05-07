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
    protected double noiseLevel;         // Nivel de ruido en decibelios (dB)
    protected String bearingType;     // Tipo de rodamientos (ej. "Ball Bearing")
    protected int inputVoltage;       // Voltaje de entrada (ej. 12V, 5V)
    protected PhysicalData physicalData;

    protected Ventilation() throws BuildException {
        
    }


    public static Ventilation getInstance(String name, String description, double price, int stockQuantity,
    double rating, String brand, boolean leds, String color, int maxAirflow, int rotationSpeed, 
    double noiseLevel, String bearingType, int inputVoltage, double high, double width, double length, double weight, boolean fragile) throws BuildException{

        String message = "";

        Ventilation fan = new Ventilation();

        try {
            fan.checkData(name, description, price, stockQuantity, rating, brand);
        } catch (BuildException e) {
            message = e.getMessage();
        }

        int resultColor = fan.setColor(color);
        if (resultColor != 0) {
            message += "El color no es correcto porque " + Checker.getErrorMessage(resultColor, 3, 32);
        }

        int resultMaxAirflow = fan.setMaxAirflow(maxAirflow);
        if (resultMaxAirflow != 0) {
            message += "El flujo de aire máximo no es correcto porque " + Checker.getErrorMessage(resultMaxAirflow, 30, 500);
        }

        int resultRotationSpeed = fan.setRotationSpeed(rotationSpeed);
        if (resultRotationSpeed != 0) {
            message += "La velocidad de rotación no es correcta porque " + Checker.getErrorMessage(resultRotationSpeed, 1200, 3500);
        }

        int resultNoiseLevel = fan.setNoiseLevel(noiseLevel);
        if (resultNoiseLevel != 0) {
            message += "El nivel de ruido no es correcto porque " + Checker.getErrorMessage(resultNoiseLevel, 20, 50);
        }

        int resultBearingType = fan.setBearingType(bearingType);
        if (resultBearingType != 0) {
            message += "El tipo de rodamientos no es correcto porque " + Checker.getErrorMessage(resultBearingType, 3, 50);
        }

        int resultInputVoltage = fan.setInputVoltage(inputVoltage);
        if (resultInputVoltage != 0) {
            message += "El voltaje de entrada no es correcto porque " + Checker.getErrorMessage(resultInputVoltage, 10, 24);
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


    public String getColor() {
        return color;
    }


    public int setColor(String color) {
        if ((Checker.isNull(color)) != 0)
            return -1;
        if ((Checker.minLength(3, color)) != 0)
            return -2;
        if ((Checker.maxLenght(32, color)) != 0)
            return -10;
        this.color = color;
        return 0;
    }


    public int getMaxAirflow() {
        return maxAirflow;
    }


    public int setMaxAirflow(int maxAirflow) {
        if (Checker.nonZero(maxAirflow) != 0) {
            return -3;
        }

        if (Checker.nonNegative(maxAirflow) != 0) {
            return -4;
        }

        if (Checker.maxValue(maxAirflow, 500) != 0) {
            return -5;
        }

        if (Checker.minValue(maxAirflow, 30) != 0) {
            return -7;
        }
        this.maxAirflow = maxAirflow;
        return 0;
    }


    public int getRotationSpeed() {
        return rotationSpeed;
    }

    public int setLeds(boolean leds) {
        this.leds = leds;
        return 0;
    }


    public int setRotationSpeed(int rotationSpeed) {
        if (Checker.nonZero(rotationSpeed) != 0) {
            return -3;
        }

        if (Checker.nonNegative(rotationSpeed) != 0) {
            return -4;
        }

        if (Checker.maxValue(rotationSpeed, 3500) != 0) {
            return -5;
        }

        if (Checker.minValue(rotationSpeed, 1200) != 0) {
            return -7;
        }
        this.rotationSpeed = rotationSpeed;
        return 0;
    }

    public double getNoiseLevel() {
        return noiseLevel;
    }


    public int setNoiseLevel(double noiseLevel) {
        if (Checker.nonZero(noiseLevel) != 0) {
            return -3;
        }

        if (Checker.nonNegative(noiseLevel) != 0) {
            return -4;
        }

        if (Checker.maxValue(noiseLevel, 50) != 0) {
            return -5;
        }

        if (Checker.minValue(noiseLevel, 20) != 0) {
            return -7;
        }
        this.noiseLevel = noiseLevel;
        return 0;
    }


    public String getBearingType() {
        return bearingType;
    }


    public int setBearingType(String bearingType) {
        if ((Checker.isNull(bearingType)) != 0)
            return -1;
        if ((Checker.minLength(3, bearingType)) != 0)
            return -2;
        if ((Checker.maxLenght(50, bearingType)) != 0)
            return -10;
        this.bearingType = bearingType;
        return 0;
    }


    public int getInputVoltage() {
        return inputVoltage;
    }


    public int setInputVoltage(int inputVoltage) {
        if (Checker.nonZero(inputVoltage) != 0) {
            return -3;
        }

        if (Checker.nonNegative(inputVoltage) != 0) {
            return -4;
        }

        if (Checker.maxValue(inputVoltage, 24) != 0) {
            return -5;
        }

        if (Checker.minValue(inputVoltage, 10) != 0) {
            return -7;
        }
        this.inputVoltage = inputVoltage;
        return 0;
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
