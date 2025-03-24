package com.example.Models.User;

import com.example.Exceptions.BuildException;
import com.example.Operations.Checker;

public class ShippingAddress {
    protected int addressId;
    protected String address;
    protected String zipCode;
    protected String city;
    protected String state;
    protected String country;

    protected ShippingAddress() {
    }

    public static ShippingAddress getInstance(int addressId, String address, String zipCode, String city, String state, String country) throws BuildException {
        String message = "";

            ShippingAddress addressObject = new ShippingAddress();

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

        public int setAddress(String address) throws BuildException{

            if(Checker.verifyAddress(address) != 0){
                throw new BuildException("BadFormat;");
            }
            this.address = address;
            return 0;
        }

        public String getZipCode() {
            return zipCode;
        }

        public int setZipCode(String zipCode) throws BuildException {
            try{
                Checker.verifyZipCode(zipCode);
            } catch (IllegalArgumentException e) {
                throw new BuildException("BadFormat;");
            }

            this.zipCode = zipCode;
            return 0;
        }

        public String getCity() {
            return city;
        }

        public int setCity(String city) throws BuildException {

            if(Checker.verifyCity(city) != 0){
                throw new BuildException("BadFormat;");
            }

            this.city = city;
            return 0;
        }

        public String getState() {
            return state;
        }

        public int setState(String state) throws BuildException {

            if (Checker.verifyState(state) != 0){
                throw new BuildException("BadFormat;");           
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

        @Override
        public String toString() {
            return "ShippingAddress [addressId=" + addressId + ", address=" + address + ", zipCode=" + zipCode
                    + ", city=" + city + ", state=" + state + ", country=" + country + "]";
        }

        
            
    }