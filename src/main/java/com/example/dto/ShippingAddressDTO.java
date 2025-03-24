package com.example.dto;



public class ShippingAddressDTO {

    private final int addressId;
    private final String address;
    private final String zipCode;
    private final String city;
    private final String state;
    private final String country;

    public ShippingAddressDTO(int addressId, String address,
                              String zipCode, String city, String state, String country) {
        this.addressId = addressId;
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public int getAddressId() {
        return addressId;
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
