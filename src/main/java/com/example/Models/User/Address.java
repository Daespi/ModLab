package com.example.Models.User;

import com.example.Exceptions.BuildException;
import com.example.Operations.Checker;

public class Address {
    protected int addressId;
    protected String address;
    protected String zipCode;
    protected String city;
    protected String state;
    protected String country;

    protected Address() {
    }

    public static Address getInstance(int addressId, String address, String zipCode, String city, String state, String country) throws BuildException {
        String message = "";

            Address addressObject = new Address();

            if ((addressObject.setAddress(address) != 0)) { 
                message += "Direccion incorrecta, ";
            }

            if ((addressObject.setZipCode(zipCode) != 0)) {
                message += "Codigo postal incorrecto, ";  
            }

            if ((addressObject.setCity(city) != 0)) {
                message += "Ciudad incorrecta, ";
            }

            if ((addressObject.setState(state) != 0)) {
                message += "Estado incorrecto, ";
            }

            if ((addressObject.setCountry(country) != 0)) {
                message += "Pais incorrecto, ";
            }

            if (message != "") {
                throw new BuildException(message);
            }

            return addressObject;
    }

        public int getAddressId() {
            return addressId;
        }

        public String getAddress() {
            return address;
        }

        public int setAddress(String address) {

            if(Checker.verifyAddress(address) != 0){
                throw new IllegalArgumentException("BadFormat;");
            }
            this.address = address;
            return 0;
        }

        public String getZipCode() {
            return zipCode;
        }

        public int setZipCode(String zipCode) {
            try{
                Checker.verifyZipCode(zipCode);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("BadFormat;");
            }

            this.zipCode = zipCode;
            return 0;
        }

        public String getCity() {
            return city;
        }

        public int setCity(String city) {

            if(Checker.verifyCity(city) != 0){
                throw new IllegalArgumentException("BadFormat;");
            }

            this.city = city;
            return 0;
        }

        public String getState() {
            return state;
        }

        public int setState(String state) {

            if (Checker.verifyState(state) != 0){
                throw new IllegalArgumentException("BadFormat;");           
            }
            this.state = state;
            return 0;
        }

        public String getCountry() {
            return country;
        }

        public int setCountry(String country) {
            this.country = country;
            return 0;
        }
            
    }
