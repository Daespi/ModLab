// package com.example.Models.Tower.Entity;

// import java.util.Set;

// import com.example.Exceptions.BuildException;
// import com.example.Models.PhysicalData.Entity.PhysicalData;
// import com.example.Models.Product.Entity.Product;
// import com.example.Operations.Checker;

// public class Tower extends Product {

//     protected String formFactor;
//     protected String color;
//     protected Set<String> connectors;
//     protected String material;
//     protected int fanSupport;
//     protected int maxGpuLength;
//     protected int maxCpuCoolerHeight;
//     protected PhysicalData physicalData;

//     protected Tower() throws BuildException {
//     }

//     public static Tower getInstance(String name, String description, double price, int stockQuantity,
//     double rating, String brand, String formFactor, String color, String connectors, String material, 
//     int fanSupport, int maxGpuLength, int maxCpuCoolerHeight, double high, double width, double length, 
//     double weight, boolean fragile) throws BuildException{


//         String message = "";

//         Tower tower = new Tower();

//         try {
//             tower.checkData(name, description, price, stockQuantity, rating, brand);
//         } catch (BuildException e) {
//             message = e.getMessage();
//         }

//         int resultFormFactor = tower.setFormFactor(formFactor);
//         if (resultFormFactor != 0) {
//             message += "El factor de forma no es correcto porque " + Checker.getErrorMessage(resultFormFactor, 5, 32);
//         }

//         int resultColor = tower.setColor(color);
//         if (resultColor != 0) {
//             message += "El color no es correcto porque " + Checker.getErrorMessage(resultColor, 3, 32);
//         }

//         int resultConnectors = tower.setConnectors(connectors);
//         if (resultConnectors != 0) {
//             message += "Los conectores no son correctos porque " + Checker.getErrorMessage(resultConnectors, 3, 50);
//         }

//         int resultMaterial = tower.setMaterial(material);
//         if (resultMaterial != 0) {
//             message += "El material no es correcto porque " + Checker.getErrorMessage(resultMaterial, 3, 50);
//         }

//         int resultFanSupport = tower.setFanSupport(fanSupport);
//         if (resultFanSupport != 0) {
//             message += "El soporte para ventiladores no es correcto porque " + Checker.getErrorMessage(resultFanSupport, 1, 2);
//         }

//         int resultMaxGpuLength = tower.setMaxGpuLength(maxGpuLength);
//         if (resultMaxGpuLength != 0) {
//             message += "La longitud máxima de GPU no es correcta porque " + Checker.getErrorMessage(resultMaxGpuLength, 160, 280);
//         }

//         int resultMaxCpuCoolerHeight = tower.setMaxCpuCoolerHeight(maxCpuCoolerHeight);
//         if (resultMaxCpuCoolerHeight != 0) {
//             message += "La altura máxima del disipador de CPU no es correcta porque " + Checker.getErrorMessage(resultMaxCpuCoolerHeight, 160, 120);
//         }

//         try {
//             tower.physicalData = PhysicalData.getInstance(high, width, length, weight, fragile);
//         } catch (BuildException ex) {
//             message += ex.getMessage();
//         }

//         if (message.length() > 0) {
//             tower = null;
//             throw new BuildException(message);
//         }

//         return tower;

//     }

//     public String getFormFactor() {
//         return formFactor;
//     }

//     public int setFormFactor(String formFactor) {
//         if ((Checker.isNull(formFactor)) != 0)
//             return -1;
//         if ((Checker.minLength(5, formFactor)) != 0)
//             return -2;
//         if ((Checker.maxLenght(32, formFactor)) != 0)
//             return -10;
//         this.formFactor = formFactor;
//         return 0;
//     }

//     public String getColor() {
//         return color;
//     }

//     public int setColor(String color) {
//         if ((Checker.isNull(color)) != 0)
//             return -1;
//         if ((Checker.minLength(3, color)) != 0)
//             return -2;
//         if ((Checker.maxLenght(32, color)) != 0)
//             return -10;
//         this.color = color;
//         return 0;
//     }

//     public String getConnectors() {
//         return connectors.toString();
//     }

//     public int setConnectors(String connectors) {
//         if ((Checker.isNull(connectors)) != 0)
//             return -1;
//         if ((Checker.minLength(3, connectors)) != 0)
//             return -2;
//         if ((Checker.maxLenght(50, connectors)) != 0)
//             return -10;
//         this.connectors.add(connectors);
//         return 0;
//     }

//     public String getMaterial() {
//         return material;
//     }

//     public int setMaterial(String material) {
//         if ((Checker.isNull(material)) != 0)
//             return -1;
//         if ((Checker.minLength(3, material)) != 0)
//             return -2;
//         if ((Checker.maxLenght(50, material)) != 0)
//             return -10;
//         this.material = material;
//         return 0;
//     }

//     public int getFanSupport() {
//         return fanSupport;
//     }

//     public int setFanSupport(int fanSupport) {
//         if (Checker.nonZero(fanSupport) != 0) {
//             return -3;
//         }

//         if (Checker.nonNegative(fanSupport) != 0) {
//             return -4;
//         }

//         if (Checker.maxValue(fanSupport, 2) != 0) {
//             return -5;
//         }
//         this.fanSupport = fanSupport;
//         return 0;
//     }

//     public int getMaxGpuLength() {
//         return maxGpuLength;
//     }

//     public int setMaxGpuLength(int maxGpuLength) {
//         if (Checker.nonZero(maxGpuLength) != 0) {
//             return -3;
//         }

//         if (Checker.nonNegative(maxGpuLength) != 0) {
//             return -4;
//         }

//         if (Checker.maxValue(maxGpuLength, 280) != 0) {
//             return -5;
//         }

//         if (Checker.minValue(maxGpuLength, 160) != 0) {
//             return -7;
//         }
//         this.maxGpuLength = maxGpuLength;
//         return 0;
//     }

//     public int getMaxCpuCoolerHeight() {
//         return maxCpuCoolerHeight;
//     }

//     public int setMaxCpuCoolerHeight(int maxCpuCoolerHeight) {
//         if (Checker.nonZero(maxCpuCoolerHeight) != 0) {
//             return -3;
//         }

//         if (Checker.nonNegative(maxCpuCoolerHeight) != 0) {
//             return -4;
//         }

//         if (Checker.maxValue(maxCpuCoolerHeight, 160) != 0) {
//             return -5;
//         }

//         if (Checker.minValue(maxCpuCoolerHeight, 120) != 0) {
//             return -7;
//         }
//         this.maxCpuCoolerHeight = maxCpuCoolerHeight;
//         return 0;
//     }


//     //-------------------------------------------------------

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