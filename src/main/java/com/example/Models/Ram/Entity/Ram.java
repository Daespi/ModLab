// package com.example.Models.Ram.Entity;

// import com.example.Exceptions.BuildException;
// import com.example.Models.PhysicalData.Entity.PhysicalData;
// import com.example.Models.Product.Entity.Product;
// import com.example.Operations.Checker;

// public class Ram extends Product {

//     protected String latency;
//     protected String typeDdr;
//     protected int internalMemory;
//     protected String memorySpeed;
//     protected Boolean led;
//     protected int memorySize;         // Tamaño de la memoria en GB
//     protected int numberOfModules;    // Número de módulos de memoria (ej. 1, 2, 4)
//     protected String voltage;         // Voltaje de la memoria (ej. 1.2V, 1.35V)
//     protected PhysicalData physicalData;

//     protected Ram() throws BuildException {
//     }

//     public static Ram getInstance(String name, String description, double price, int stockQuantity,
//     double rating, String brand, String latency, String typeDdr, int internalMemory, String memorySpeed, boolean led, 
//     int memorySize, int numberOfModules, String voltage, double high, double width, double length, 
//     double weight, boolean fragile) throws BuildException {

//         String message = "";

//         Ram ram = new Ram();

//         try {
//             ram.checkData(name, description, price, stockQuantity, rating, brand);
//         } catch (BuildException e) {
//             message = e.getMessage();
//         }

//         int resultLatency = ram.setLatency(latency);
//         if (resultLatency != 0) {
//             message += "Esta latencia no es correcta porque " + Checker.getErrorMessage(resultLatency, 3, 20);
//         }

//         int resultTypeDdr = ram.setTypeDdr(typeDdr);
//         if (resultTypeDdr != 0) {
//             message += "Este tipo de ddr no es correcto porque " + Checker.getErrorMessage(resultTypeDdr, 3, 15);
//         }

//         int resultInternalMemory = ram.setInternalMemory(internalMemory);
//         if (resultInternalMemory != 0) {
//             message += "Esta memoria interna no es correcta porque " + Checker.getErrorMessage(resultInternalMemory, 4, 128);
//         }

//         int resultMemorySpeed = ram.setMemorySpeed(memorySpeed);
//         if (resultMemorySpeed != 0) {
//             message += "Esta velocidad de memoria no es correcta porque " + Checker.getErrorMessage(resultMemorySpeed, 8, 32);
//         }

//         int resultMemorySize = ram.setMemorySize(memorySize);
//         if (resultMemorySize != 0) {
//             message += "El tamaño de la memoria no es correcto porque " + Checker.getErrorMessage(resultMemorySize, 2, 256);
//         }

//         int resultNumberOfModules = ram.setNumberOfModules(numberOfModules);
//         if (resultNumberOfModules != 0) {
//             message += "El número de módulos no es correcto porque " + Checker.getErrorMessage(resultNumberOfModules, 0, 8);
//         }

//         int resultVoltage = ram.setVoltage(voltage);
//         if (resultVoltage != 0) {
//             message += "El voltaje de la memoria no es correcto porque " + Checker.getErrorMessage(resultVoltage, 8, 32);
//         }

//         try {
//             ram.physicalData = PhysicalData.getInstance(high, width, length, weight, fragile);
//         } catch (BuildException ex) {
//             message += ex.getMessage();
//         }

//         if (message.length() > 0) {
//             ram = null;
//             throw new BuildException(message);
//         }

//         return ram;
//     }

//     public String getLatency() {
//         return latency;
//     }

//     public int setLatency(String latency) {
//         if ((Checker.isNull(latency)) != 0)
//             return -1;
//         if ((Checker.minLength(3, latency)) != 0)
//             return -2;
//         if ((Checker.maxLenght(20, latency)) != 0)
//             return -10;
//         this.latency = latency;
//         return 0;
//     }

//     public String getTypeDdr() {
//         return typeDdr;
//     }

//     public int setTypeDdr(String typeDdr) {
//         if ((Checker.isNull(typeDdr)) != 0)
//             return -1;
//         if ((Checker.minLength(3, typeDdr)) != 0)
//             return -2;
//         if ((Checker.maxLenght(15, typeDdr)) != 0)
//             return -10;
//         this.typeDdr = typeDdr;
//         return 0;
//     }

//     // Getter and Setter methods for internalMemory
//     public int getInternalMemory() {
//         return internalMemory;
//     }

//     public int setInternalMemory(int internalMemory) {
//         if (Checker.nonZero(internalMemory) != 0) {
//             return -3;
//         }

//         if (Checker.nonNegative(internalMemory) != 0) {
//             return -4;
//         }

//         if (Checker.maxValue(internalMemory, 128) != 0) {
//             return -5;
//         }

//         if (Checker.minValue(internalMemory, 4) != 0) {
//             return -7;
//         }
//         this.internalMemory = internalMemory;
//         return 0;
//     }

//     // Getter and Setter methods for memorySpeed
//     public String getMemorySpeed() {
//         return memorySpeed;
//     }

//     public int setMemorySpeed(String memorySpeed) {
//         if ((Checker.isNull(memorySpeed)) != 0)
//             return -1;
//         if ((Checker.minLength(8, memorySpeed)) != 0)
//             return -2;
//         if ((Checker.maxLenght(32, memorySpeed)) != 0)
//             return -10;
//         this.memorySpeed = memorySpeed;
//         return 0;
//     }

//     public Boolean getLed() {
//         return led;
//     }

//     public int setLed(Boolean led) {
//         this.led = led;
//         return 0;
//     }

//     public int getMemorySize() {
//         return memorySize;
//     }

//     public int setMemorySize(int memorySize) {
//         if (Checker.nonZero(memorySize) != 0) {
//             return -3;
//         }

//         if (Checker.nonNegative(memorySize) != 0) {
//             return -4;
//         }

//         if (Checker.maxValue(memorySize, 256) != 0) {
//             return -5;
//         }

//         if (Checker.minValue(memorySize, 2) != 0) {
//             return -7;
//         }
//         this.memorySize = memorySize;
//         return 0;
//     }

//     public int getNumberOfModules() {
//         return numberOfModules;
//     }

//     public int setNumberOfModules(int numberOfModules) {
//         if (Checker.nonZero(numberOfModules) != 0) {
//             return -3;
//         }

//         if (Checker.nonNegative(numberOfModules) != 0) {
//             return -4;
//         }

//         if (Checker.maxValue(numberOfModules, 8) != 0) {
//             return -5;
//         }
//         this.numberOfModules = numberOfModules;
//         return 0;
//     }

//     public String getVoltage() {
//         return voltage;
//     }

//     public int setVoltage(String voltage) {
//         if ((Checker.isNull(voltage)) != 0)
//             return -1;
//         if ((Checker.minLength(8, voltage)) != 0)
//             return -2;
//         if ((Checker.maxLenght(32, voltage)) != 0)
//             return -10;
//         this.voltage = voltage;
//         return 0;
//     }


//     //----------------------------

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