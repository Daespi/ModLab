// package com.example.Models.GraphicCard.Entity;

// import com.example.Exceptions.BuildException;
// import com.example.Models.PhysicalData.Entity.PhysicalData;
// import com.example.Models.Product.Entity.Product;
// import com.example.Operations.Checker;

// public class GraphicCard extends Product{

    
//     protected String color;
//     protected int memory;
//     protected String memoryType;
//     protected int recommendedPowerSupply;
//     protected double coreClock;                // Frecuencia base del GPU (MHz)
//     protected double boostClock;               // Frecuencia máxima del GPU (MHz)
//     protected int tdp;                      // Consumo térmico en watts
//     protected String interfaceConnection;   // Tipo de conexión, ej. PCIe 4.0 x16
//     protected PhysicalData physicalData;

//     protected GraphicCard() throws BuildException {
//     }

//     public static GraphicCard getInstance(String name, String description, double price, int stockQuantity,
//     double rating, String brand, String color, int memory, String memoryType, 
//     int recommendedPowerSupply, double coreClock, double boostClock, int tdp, String interfaceConnection, double high, double width, double length, double weight, boolean fragile) throws BuildException {

//         String message = "";
//         GraphicCard gc = new GraphicCard();

//         try {
//             gc.checkData(name, description, price, stockQuantity, rating, brand);
//         } catch (BuildException e) {
//             message = e.getMessage();
//         }

//         int resultColor = gc.setColor(color);
//         if (resultColor != 0) {
//             message += "El color no es correcto porque " + Checker.getErrorMessage(resultColor, 2, 50);
//         }

//         int resultMemory = gc.setMemory(memory);
//         if (resultMemory != 0) {
//             message += "La memoria no es correcta porque " + Checker.getErrorMessage(resultMemory, 2, 24);
//         }

//         int resultMemoryType = gc.setMemoryType(memoryType);
//         if (resultMemoryType != 0) {
//             message += "El tipo de memoria no es correcto porque " + Checker.getErrorMessage(resultMemoryType, 2, 50);
//         }

//         int resultPower = gc.setRecommendedPowerSupply(recommendedPowerSupply);
//         if (resultPower != 0) {
//             message += "La fuente de poder recomendada no es correcta porque " + Checker.getErrorMessage(resultPower, 300, 750);
//         }

//         int resultCoreClock = gc.setCoreClock(coreClock);
//         if (resultCoreClock != 0) {
//             message += "La frecuencia base del núcleo no es correcta porque " + Checker.getErrorMessage(resultCoreClock, 1.2, 1.5);
//         }

//         int resultBoostClock = gc.setBoostClock(boostClock);
//         if (resultBoostClock != 0) {
//             message += "La frecuencia boost no es correcta porque " + Checker.getErrorMessage(resultBoostClock, 1.8, 2.5);
//         }

//         int resultTdp = gc.setTdp(tdp);
//         if (resultTdp != 0) {
//             message += "El TDP no es correcto porque " + Checker.getErrorMessage(resultTdp, 50, 350);
//         }

//         int resultInterfaceConnection = gc.setInterfaceConnection(interfaceConnection);
//         if (resultInterfaceConnection != 0) {
//             message += "La interfaz de conexión no es correcta porque " + Checker.getErrorMessage(resultInterfaceConnection, 2, 150);
//         }


//         try {
//             gc.physicalData = PhysicalData.getInstance(high, width, length, weight, fragile);
//         } catch (BuildException ex) {
//             message += ex.getMessage();
//         }

//         if (!message.isEmpty()) {
//             gc = null;
//             throw new BuildException(message);
//         }

//         return gc;
//     }

//     public String getColor() {
//         return color;
//     }

//     public int setColor(String color) {
//         if ((Checker.isNull(color)) != 0)
//             return -1;
//         if ((Checker.minLength(2, color)) != 0)
//             return -2;
//         if ((Checker.maxLenght(50, color)) != 0)
//             return -10;
//         this.color = color;
//         return 0;
//     }

//     public int getMemory() {
//         return memory;
//     }

//     public int setMemory(int memory) {
//         if (Checker.nonZero(memory) != 0) {
//             return -3;
//         }

//         if (Checker.nonNegative(memory) != 0) {
//             return -4;
//         }

//         if (Checker.maxValue(memory, 	24) != 0) {
//             return -5;
//         }

//         if (Checker.minValue(memory,  2) != 0) {
//             return -7;
//         }
//         this.memory = memory;
//         return 0;
//     }

//     public String getMemoryType() {
//         return memoryType;
//     }

//     public int setMemoryType(String memoryType) {
//         if ((Checker.isNull(memoryType)) != 0)
//             return -1;
//         if ((Checker.minLength(2, memoryType)) != 0)
//             return -2;
//         if ((Checker.maxLenght(50, memoryType)) != 0)
//             return -10;
//         this.memoryType = memoryType;
//         return 0;
//     }

//     public int getRecommendedPowerSupply() {
//         return recommendedPowerSupply;
//     }

//     public int setRecommendedPowerSupply(int recommendedPowerSupply) {
//         if (Checker.nonZero(recommendedPowerSupply) != 0) {
//             return -3;
//         }

//         if (Checker.nonNegative(recommendedPowerSupply) != 0) {
//             return -4;
//         }

//         if (Checker.maxValue(recommendedPowerSupply, 750) != 0) {
//             return -5;
//         }

//         if (Checker.minValue(recommendedPowerSupply,  300) != 0) {
//             return -7;
//         }
//         this.recommendedPowerSupply = recommendedPowerSupply;
//         return 0;
//     }


//     public double getCoreClock() {
//         return coreClock;
//     }

//     public int setCoreClock(double coreClock) {
//         if (Checker.nonZero(coreClock) != 0) {
//             return -3;
//         }

//         if (Checker.nonNegative(coreClock) != 0) {
//             return -4;
//         }

//         if (Checker.maxValue(coreClock, 1.5 ) != 0) {
//             return -5;
//         }

//         if (Checker.minValue(coreClock,  1.2 ) != 0) {
//             return -7;
//         }
//         this.coreClock = coreClock;
//         return 0;
//     }

//     public double getBoostClock() {
//         return boostClock;
//     }

//     public int setBoostClock(double boostClock) {
//         if (Checker.nonZero(boostClock) != 0) {
//             return -3;
//         }

//         if (Checker.nonNegative(boostClock) != 0) {
//             return -4;
//         }

//         if (Checker.maxValue(boostClock, 2.5) != 0) {
//             return -5;
//         }

//         if (Checker.minValue(boostClock,  1.8) != 0) {
//             return -7;
//         }
//         this.boostClock = boostClock;
//         return 0;
//     }

//     public int getTdp() {
//         return tdp;
//     }

//     public int setTdp(int tdp) {
//         if (Checker.nonZero(tdp) != 0) {
//             return -3;
//         }

//         if (Checker.nonNegative(tdp) != 0) {
//             return -4;
//         }

//         if (Checker.maxValue(tdp, 50) != 0) {
//             return -5;
//         }

//         if (Checker.minValue(tdp,  350) != 0) {
//             return -7;
//         }
//         this.tdp = tdp;
//         return 0;
//     }

//     public String getInterfaceConnection() {
//         return interfaceConnection;
//     }

//     public int setInterfaceConnection(String interfaceConnection) {
//         if ((Checker.isNull(interfaceConnection)) != 0)
//             return -1;
//         if ((Checker.minLength(2, interfaceConnection)) != 0)
//             return -2;
//         if ((Checker.maxLenght(150, interfaceConnection)) != 0)
//             return -10;
//         this.interfaceConnection = interfaceConnection;
//         return 0;
//     }

//     //--------------------------------------------------

//     public double getWidth() {
//         return physicalData.getWidth();
//     }

//     public double getHigh() {
//         return physicalData.getHigh();
//     }

//     public double getLength() {
//         return physicalData.getLength();
//     }

//     public double getWeight() {
//         return physicalData.getWeight();
//     }

//     public Boolean getFragile() {
//         return physicalData.getFragile();
//     }

//     // Setters for physical properties
//     public int setWidth(double width) {
//         return physicalData.setWidth(width);
//     }

//     public int setLength(double length) {
//         return physicalData.setLength(length);
//     }

//     public int setHigh(double high) {
//         return physicalData.setHigh(high);
//     }

//     public int setWeight(double weight) {
//         return physicalData.setWeight(weight);
//     }

//     public int setFragil(Boolean fragile) {
//         return physicalData.setFragile(fragile);
//     }

//     // Method to calculate volume
//     public double getVolume() {
//         return physicalData.getVolume();
//     }

// }

