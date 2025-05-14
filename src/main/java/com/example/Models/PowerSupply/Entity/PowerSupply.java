// package com.example.Models.PowerSupply.Entity;

// import java.util.HashSet;
// import java.util.Set;

// import com.example.Exceptions.BuildException;
// import com.example.Models.GraphicCard.Entity.GraphicCard;
// import com.example.Models.PhysicalData.Entity.PhysicalData;
// import com.example.Models.Product.Entity.Product;
// import com.example.Operations.Checker;

// public class PowerSupply extends Product{

//     protected String model;
//     protected String color;
//     protected int totalPower;
//     protected Set<String> connectors;
//     protected String frecuency;
//     protected PhysicalData physicalData;

//     protected PowerSupply() throws BuildException {
//         this.connectors = new HashSet<String>();
//     }

//     public static PowerSupply getInstance(String name, String description, double price, int stockQuantity,
//     double rating, String brand, String model, String color, int totalPower, String connectors, String frecuency, 
//     double high, double width, double length, double weight, boolean fragile) throws BuildException{

//         String message = "";
//         PowerSupply ps = new PowerSupply();

//         try {
//             ps.checkData(name, description, price, stockQuantity, rating, brand);
//         } catch (BuildException e) {
//             message = e.getMessage();
//         }


//         int resultModel = ps.setModel(model);
//         if (resultModel != 0) {
//             message += "El modelo no es correcto porque " + Checker.getErrorMessage(resultModel, 3, 20);
//         }

//         int resultColor = ps.setColor(color);
//         if (resultColor != 0) {
//             message += "El color no es correcto porque " + Checker.getErrorMessage(resultColor, 3, 15);
//         }

//         int resultPower = ps.setTotalPower(totalPower);
//         if (resultPower != 0) {
//             message += "El consumo total de energía no es correcto porque " + Checker.getErrorMessage(resultPower, 300, 1500);
//         }

//         int resultConnectors = ps.setConnectors(connectors);
//         if (resultConnectors != 0) {
//             message += "Los conectores no son correctos porque " + Checker.getErrorMessage(resultConnectors, 3, 50);
//         }

//         int resultFrecuency = ps.setFrecuency(frecuency);
//         if (resultFrecuency != 0) {
//             message += "La frecuencia no es correcta porque " + Checker.getErrorMessage(resultFrecuency, 3, 15);
//         }


//         try {
//             ps.physicalData = PhysicalData.getInstance(high, width, length, weight, fragile);
//         } catch (BuildException ex) {
//             message += ex.getMessage();
//         }


//         if (message.length() > 0) {
//             ps = null;
//             throw new BuildException(message);
//         }

//         return ps;
//     }

//     public String getModel() {
//         return model;
//     }

//     public int setModel(String model) {
//         if ((Checker.isNull(model)) != 0)
//             return -1;
//         if ((Checker.minLength(3, model)) != 0)
//             return -2;
//         if ((Checker.maxLenght(20, model)) != 0)
//             return -10;
//         this.model = model;
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
//         if ((Checker.maxLenght(15, color)) != 0)
//             return -10;
//         this.color = color;
//         return 0;
//     }

//     public int getTotalPower() {
//         return totalPower;
//     }

//     public int setTotalPower(int totalPower) {
//         if (Checker.nonZero(totalPower) != 0) {
//             return -3;
//         }

//         if (Checker.nonNegative(totalPower) != 0) {
//             return -4;
//         }

//         if (Checker.maxValue(totalPower, 1500) != 0) {
//             return -5;
//         }

//         if (Checker.minValue(totalPower, 300) != 0) {
//             return -7;
//         }
//         this.totalPower = totalPower;
//         return 0;
//     }

//     public String getConnectors() {
//         return connectors.toString();
//     }

//     public int setConnectors(String connectors) {
//         if ((Checker.isNull(connectors)) != 0)
//                 return -1;
//         if ((Checker.minLength(3, connectors)) != 0)
//                 return -2;
//         if ((Checker.maxLenght(50, connectors)) != 0)
//                 return -10; 
//             this.connectors.add(connectors);
//             return 0;
//     }

//     public String getFrecuency() {
//         return frecuency;
//     }

//     public int setFrecuency(String frecuency) {
//         if ((Checker.isNull(frecuency)) != 0)
//             return -1;
//         if ((Checker.minLength(3, frecuency)) != 0)
//             return -2;
//         if ((Checker.maxLenght(15, frecuency)) != 0)
//             return -10;
//         this.frecuency = frecuency;
//         return 0;
//     }

//     //-------------------------------------------

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

