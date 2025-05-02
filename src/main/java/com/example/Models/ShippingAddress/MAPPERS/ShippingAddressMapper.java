package com.example.Models.ShippingAddress.MAPPERS;

import com.example.Exceptions.BuildException;
import com.example.Models.ShippingAddress.DTO.ShippingAddressDTO;
import com.example.Models.ShippingAddress.Entity.ShippingAddress;

public class ShippingAddressMapper {

    public static ShippingAddress addressFromDTO(ShippingAddressDTO dto) throws BuildException {
        return ShippingAddress.getInstance( 

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