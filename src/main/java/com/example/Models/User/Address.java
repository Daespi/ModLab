package com.example.Models.User;

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

    public stataic Address getInstance(int addressId, String address, String zipCode, String city, String state, String country) {
        String message = "";
    }

        public int getAddressId() {
            return addressId;
        }

        public String getAddress() {
            return address;
        }

        public int setAddress(String address) {
            if (Checker.isNull(address) != 0) {
                return -1;
            }
            try{
                Checker.verifyAddress(address);
            } catch (IllegalArgumentException e) {
                return -1;
            }
            this.address = address;
            return 0;
        }

        public String getZipCode() {
            return zipCode;
        }

        public int setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }

        public String getCity() {
            return city;
        }

        public int setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public int setState(String state) {
            this.state = state;
        }

        public String getCountry() {
            return country;
        }

        public int setCountry(String country) {
            this.country = country;
        }
            
    }
