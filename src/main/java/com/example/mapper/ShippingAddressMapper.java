package com.example.mapper;

import com.example.dto.ShippingAddressDTO;
import com.example.Models.User.ShippingAddress;
import com.example.Exceptions.BuildException;

public class ShippingAddressMapper {

    public static ShippingAddress addressFromDTO(ShippingAddressDTO dto) throws BuildException {
        return ShippingAddress.getInstance(
                dto.getAddressId(),
                dto.getAddress(),
                dto.getZipCode(),
                dto.getCity(),
                dto.getState(),
                dto.getCountry()
        );
    }

    public static ShippingAddressDTO dtoFromAddress(ShippingAddress address) {
        return new ShippingAddressDTO(
                address.getAddressId(),
                address.getAddress(),
                address.getZipCode(),
                address.getCity(),
                address.getState(),
                address.getCountry()
        );
    }
}