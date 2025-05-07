package com.example.Models.PlacaBase.Entity;

import com.example.Exceptions.BuildException;
import com.example.Models.PhysicalData.Entity.PhysicalData;
import com.example.Models.Product.Entity.Product;
import com.example.Operations.Checker;

public class Motherboard extends Product{

    protected boolean cpu;
    protected String memory;
    protected String storage;
    protected String factorForm;
    protected String socket;               // Tipo de socket para CPU (ej. AM5, LGA1700)
    protected String chipset;              // Chipset de la placa (ej. B650, Z790)
    protected String memoryType;           // Tipo de RAM soportada (ej. DDR4, DDR5)
    protected int memorySlots;             // Número de ranuras RAM
    protected int maxMemory;               // Memoria máxima soportada (en GB)
    protected PhysicalData physicalData;



    protected Motherboard() throws BuildException{

    }


    public static Motherboard getInstance(String name, String description, double price, int stockQuantity,
    double rating, String brand, boolean cpu, String memory, String storage, 
    String factorForm, String socket, String chipset, String memoryType, int memorySlots, int maxMemory, double high, double width, double length, double weight, 
    boolean fragile) throws BuildException{
        
        String message = "";

        Motherboard motherboard = new Motherboard();

        try {
            motherboard.checkData(name, description, price, stockQuantity, rating, brand);
        } catch (BuildException e) {
            message = e.getMessage();
        }

        int resultMemory = motherboard.setMemory(memory);
        if (resultMemory != 0) {
            message += "Esta memoria no es correcta porque" + Checker.getErrorMessage(resultMemory, 20, 150);
        }

        int resultStorage = motherboard.setStorage(storage);
        if (resultStorage != 0) {
            message += "Este storage no es correcto porque" + Checker.getErrorMessage(resultStorage, 10, 50);
        }

        int resultFactorForm = motherboard.setFactorForm(factorForm);
        if (resultFactorForm != 0) {
            message += "Esta forma de factor no es correcta porque" + Checker.getErrorMessage(resultFactorForm, 4, 150);
        }

        int resultSocket = motherboard.setSocket(socket);
        if (resultSocket != 0) {
            message += "El tipo de socket no es correcto porque " + Checker.getErrorMessage(resultSocket, 4, 25);
        }

        int resultChipset = motherboard.setChipset(chipset);
        if (resultChipset != 0) {
            message += "El chipset no es correcto porque " + Checker.getErrorMessage(resultChipset, 4, 25);
        }

        int resultMemoryType = motherboard.setMemoryType(memoryType);
        if (resultMemoryType != 0) {
            message += "El tipo de memoria no es correcto porque " + Checker.getErrorMessage(resultMemoryType, 4, 25);
        }

        int resultMemorySlots = motherboard.setMemorySlots(memorySlots);
        if (resultMemorySlots != 0) {
            message += "El número de ranuras de memoria no es correcto porque " + Checker.getErrorMessage(resultMemorySlots, 2, 8);
        }

        int resultMaxMemory = motherboard.setMaxMemory(maxMemory);
        if (resultMaxMemory != 0) {
            message += "La memoria máxima soportada no es correcta porque " + Checker.getErrorMessage(resultMaxMemory, 64, 512);
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


    public boolean getCpu() {
        return cpu;
    }

    public void setCpu(boolean cpu) {
        this.cpu = cpu;
    }


    public String getMemory() {
        return memory;
    }


    public int setMemory(String memory) {
        if ((Checker.isNull(memory)) != 0)
            return -1;
        if ((Checker.minLength(20, memory)) != 0)
            return -2;
        if ((Checker.maxLenght(150, memory)) != 0)
            return -10;
        this.memory = memory;
        return 0;
    }


    public String getStorage() {
        return storage;
    }


    public int setStorage(String storage) {
        if ((Checker.isNull(storage)) != 0)
            return -1;
        if ((Checker.minLength(10, storage)) != 0)
            return -2;
        if ((Checker.maxLenght(50, storage)) != 0)
            return -10;
        this.storage = storage;
        return 0;
    }


    public String getFactorForm() {
        return factorForm;
    }


    public int setFactorForm(String factorForm) {
        if ((Checker.isNull(factorForm)) != 0)
            return -1;
        if ((Checker.minLength(4, factorForm)) != 0)
            return -2;
        if ((Checker.maxLenght(150, factorForm)) != 0)
            return -10;
        this.factorForm = factorForm;
        return 0;
    }

    public String getSocket() {
        return socket;
    }


    public int setSocket(String socket) {
        if ((Checker.isNull(socket)) != 0)
            return -1;
        if ((Checker.minLength(4, socket)) != 0)
            return -2;
        if ((Checker.maxLenght(25, socket)) != 0)
            return -10;
        this.socket = socket;
        return 0;
    }


    public String getChipset() {
        return chipset;
    }


    public int setChipset(String chipset) {
        if ((Checker.isNull(chipset)) != 0)
            return -1;
        if ((Checker.minLength(4, chipset)) != 0)
            return -2;
        if ((Checker.maxLenght(25, chipset)) != 0)
            return -10;
        this.chipset = chipset;
        return 0;
    }


    public String getMemoryType() {
        return memoryType;
    }


    public int setMemoryType(String memoryType) {
        if ((Checker.isNull(memoryType)) != 0)
            return -1;
        if ((Checker.minLength(4, memoryType)) != 0)
            return -2;
        if ((Checker.maxLenght(25, memoryType)) != 0)
            return -10;
        this.memoryType = memoryType;
        return 0;
    }


    public int getMemorySlots() {
        return memorySlots;
    }


    public int setMemorySlots(int memorySlots) {
        if (Checker.nonZero(memorySlots) != 0) {
            return -3;
        }

        if (Checker.nonNegative(memorySlots) != 0) {
            return -4;
        }

        if (Checker.maxValue(memorySlots, 8) != 0) {
            return -5;
        }

        if (Checker.minValue(memorySlots, 2) != 0) {
            return -7;
        }
        this.memorySlots = memorySlots;
        return 0;
    }


    public int getMaxMemory() {
        return maxMemory;
    }


    public int setMaxMemory(int maxMemory) {
        if (Checker.nonZero(maxMemory) != 0) {
            return -3;
        }

        if (Checker.nonNegative(maxMemory) != 0) {
            return -4;
        }

        if (Checker.maxValue(maxMemory, 	512) != 0) {
            return -5;
        }

        if (Checker.minValue(maxMemory, 64) != 0) {
            return -7;
        }
        this.maxMemory = maxMemory;
        return 0;
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
