package com.example.Models.ShippingAddress.MAPPERS;

import com.example.Exceptions.BuildException;
import com.example.Models.ShippingAddress.DTO.ShippingAddressDTO;
import com.example.Models.ShippingAddress.Entity.ShippingAddress;

public class ShippingAddressMapper {

    public static ShippingAddress addressFromDTO(ShippingAddressDTO dto) throws BuildException {
<<<<<<< HEAD
        return ShippingAddress.getInstance( 
=======
        return ShippingAddress.getInstance(
>>>>>>> dev_alex
                dto.getAddress(),
                dto.getZipCode(),
                dto.getCity(),
                dto.getState(),
                dto.getCountry()
        );
    }

    public static ShippingAddressDTO dtoFromAddress(ShippingAddress address) {
        return new ShippingAddressDTO(
<<<<<<< HEAD
                address.getAddressId(),     
=======
>>>>>>> dev_alex
                address.getAddress(),
                address.getZipCode(),
                address.getCity(),
                address.getState(),
                address.getCountry()
        );
    }
}