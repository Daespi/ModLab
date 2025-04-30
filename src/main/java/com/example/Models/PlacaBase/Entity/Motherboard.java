package com.example.Models.PlacaBase.Entity;

import com.example.Exceptions.BuildException;
import com.example.Models.PhysicalData.Entity.PhysicalData;
import com.example.Models.Product.Entity.Product;
import com.example.Operations.Checker;

public class Motherboard extends Product{

    protected String cpu;
    protected String memory;
    protected String storage;
    protected String factorForm;
    protected PhysicalData physicalData;



    protected Motherboard() throws BuildException{

    }


    public static Motherboard getInstance(String name, String description, double price, int stockQuantity,
    double rating, String brand, String cpu, String memory, String storage, 
    String factorForm, double high, double width, double length, double weight, 
    boolean fragile) throws BuildException{
        


        String message = "";

        Motherboard motherboard = new Motherboard();

        try {
            motherboard.checkData(name, description, price, stockQuantity, rating, brand);
        } catch (BuildException e) {
            message = e.getMessage();
        }


        int resultCpu = motherboard.setCpu(cpu);
        if (resultCpu != 0) {
            message += "Esta CPU no es correcta porque" + Checker.getErrorMessage(resultCpu, 0, 1.20);
        }

        int resultMemory = motherboard.setMemory(memory);
        if (resultMemory != 0) {
            message += "Esta memoria no es correcta porque" + Checker.getErrorMessage(resultMemory, 0, 1.20);
        }

        int resultStorage = motherboard.setStorage(storage);
        if (resultStorage != 0) {
            message += "Este storage no es correcto porque" + Checker.getErrorMessage(resultStorage, 0, 1.20);
        }

        int resultFactorForm = motherboard.setFactorForm(factorForm);
        if (resultFactorForm != 0) {
            message += "Esta forma de factor no es correcta porque" + Checker.getErrorMessage(resultFactorForm, 0, 1.20);
        }

        try {
            motherboard.physicalData = PhysicalData.getInstance(high, width, length, weight, fragile);
        } catch (BuildException ex) {
            message += ex.getMessage();
        }

        if (message.length() > 0) {
            motherboard = null;
            throw new BuildException(message);
        }
        return motherboard;
    }


    public String getCpu() {
        return cpu;
    }


    public int setCpu(String cpu) {
        if ((Checker.isNull(cpu)) != 0)
            return -1;
        if ((Checker.minLength(10, cpu)) != 0)
            return -2;
        if ((Checker.maxLenght(150, cpu)) != 0)
            return -10;
        this.cpu = cpu;
        return 0;
    }


    public String getMemory() {
        return memory;
    }


    public int setMemory(String memory) {
        if ((Checker.isNull(memory)) != 0)
            return -1;
        this.memory = memory;
        return 0;
    }


    public String getStorage() {
        return storage;
    }


    public int setStorage(String storage) {
        if ((Checker.isNull(cpu)) != 0)
            return -1;
        this.storage = storage;
        return 0;
    }


    public String getFactorForm() {
        return factorForm;
    }


    public int setFactorForm(String factorForm) {
        if ((Checker.isNull(factorForm)) != 0)
            return -1;
        this.factorForm = factorForm;
        return 0;
    }


    public PhysicalData getPhysicalData() {
        return physicalData;
    }


    public void setPhysicalData(PhysicalData physicalData) {
        this.physicalData = physicalData;
    }

    //---------------------------
    
    
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
