package com.example.dto;



public class ShippingAddressDTO {


    private final String address;
    private final String zipCode;
    private final String city;
    private final String state;
    private final String country;

    public ShippingAddressDTO( String address,
                              String zipCode, String city, String state, String country) {
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
        this.state = state;
        this.country = country;
    }


    public String getAddress() {
        return address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }
}
