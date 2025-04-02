package com.example.Models.ShippingAddress.Entity;

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

    public static ShippingAddress getInstance(String address, String zipCode, String city, String state, String country) throws BuildException {
        String message = "";

            ShippingAddress addressObject = new ShippingAddress();

            int resultAdress = addressObject.setAddress(address);
            if (resultAdress != 0) {
                message += "La dirección no es correcta porque" + Checker.getErrorMessage(resultAdress, 0, 0);
            }

            int resultZipCode = addressObject.setZipCode(zipCode);
            if (resultZipCode != 0) {
                message += "El código postal no es correcto porque" + Checker.getErrorMessage(resultZipCode, 0, 0);
            }

            int resultCity = addressObject.setCity(city);
            if (resultCity != 0) {
                message += "La ciudad no es correcta porque" + Checker.getErrorMessage(resultCity, 0, 0);
            }

            int resultState = addressObject.setState(state);
            if (resultState != 0) {
                message += "La comunidad autónoma no es correcta porque" + Checker.getErrorMessage(resultState, 0, 0);
            }

            int resultCountry = addressObject.setCountry(country);
            if (resultCountry != 0) {
                message += "La comunidad autónoma no es correcta porque" + Checker.getErrorMessage(resultCountry, 0, 0);
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

        public int setAddress(String address){
            if(Checker.isNull(address) != 0){
                return -1;
            }
            if(Checker.verifyAddress(address) != 0){
                return -16;
            }
            this.address = address;
            return 0;
        }

        public String getZipCode() {
            return zipCode;
        }

        public int setZipCode(String zipCode) {
            if(Checker.isNull(zipCode) != 0){
                return -1;
            }
            if(Checker.verifyZipCode(zipCode) != 0){
                return -17;
            }
            this.zipCode = zipCode;
            return 0;
        }

        public String getCity() {
            return city;
        }

        public int setCity(String city) {
            if(Checker.isNull(city) != 0){
                return -1;
            }
            if(Checker.verifyCity(city) != 0){
                return -18;
            }

            this.city = city;
            return 0;
        }

        public String getState() {
            return state;
        }

        public int setState(String state) throws BuildException {
            if(Checker.isNull(state) != 0){
                return -1;
            }
            if (Checker.verifyState(state) != 0){
                return -19;           
            }
            this.state = state;
            return 0;
        }

        public String getCountry() {
            return country;
        }

        public int setCountry(String country) {
            if(Checker.isNull(country) != 0){
                return -1;
            }
            if (Checker.verifyCountry(country) != 0){
                return -20;           
            }
            this.country = country;
            return 0;
        }

        @Override
        public String toString() {
            return "ShippingAddress [addressId=" + addressId + ", address=" + address + ", zipCode=" + zipCode
                    + ", city=" + city + ", state=" + state + ", country=" + country + "]";
        }

        
            
    }