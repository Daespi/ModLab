package com.example.Models.ShippingAddress.DTO;

<<<<<<< HEAD
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "shipping_address", schema = "modlab")
public class ShippingAddressDTO {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private int addressId;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "zip_code", nullable = false)
    private String zipCode;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "country", nullable = false)
    private String country;

    public ShippingAddressDTO() {}

    public ShippingAddressDTO(int addressId, String address,
                              String zipCode, String city, String state, String country) {
        this.addressId = addressId;
=======


public class ShippingAddressDTO {


    private final String address;
    private final String zipCode;
    private final String city;
    private final String state;
    private final String country;

    public ShippingAddressDTO( String address,
                              String zipCode, String city, String state, String country) {
>>>>>>> dev_alex
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
        this.state = state;
        this.country = country;
    }

<<<<<<< HEAD
    public int getAddressId() {
        return addressId;
    }
=======
>>>>>>> dev_alex

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
