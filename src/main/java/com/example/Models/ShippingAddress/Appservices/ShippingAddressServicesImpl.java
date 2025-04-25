package com.example.Models.ShippingAddress.Appservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.Exceptions.BuildException;
import com.example.Exceptions.ServiceException;
import com.example.Models.ShippingAddress.DTO.ShippingAddressDTO;
import com.example.Models.ShippingAddress.MAPPERS.ShippingAddressMapper;
import com.example.Models.ShippingAddress.Persistence.ShippingAddressRepository;
import com.example.sharedkernel.appservices.serializers.Serializer;
import com.example.sharedkernel.appservices.serializers.Serializers;
import com.example.sharedkernel.appservices.serializers.SerializersCatalog;

@Controller
public class ShippingAddressServicesImpl implements ShippingAddressServices {

    @Autowired
    private ShippingAddressRepository shippingAddressRepository;

    private Serializer<ShippingAddressDTO> serializer;

    protected ShippingAddressDTO getDTO(int addressId) {
        return shippingAddressRepository.findById(addressId).orElse(null);
    }

    protected ShippingAddressDTO getById(int addressId) throws ServiceException {
        ShippingAddressDTO dto = this.getDTO(addressId);

        if (dto == null) {
            throw new ServiceException("Shipping address " + addressId + " not found");
        }
        return dto;
    }

    protected ShippingAddressDTO checkInputData(String json) throws ServiceException {
        try {
            ShippingAddressDTO dto = this.serializer.deserialize(json, ShippingAddressDTO.class);
            ShippingAddressMapper.addressFromDTO(dto); // Validación con lógica de negocio
            return dto;
        } catch (BuildException e) {
            throw new ServiceException("Error in the input shipping address data: " + e.getMessage());
        }
    }

    protected ShippingAddressDTO newAddress(String json) throws ServiceException {
        ShippingAddressDTO dto = this.checkInputData(json);

        if (this.getDTO(dto.getAddressId()) == null) {
            return shippingAddressRepository.save(dto);
        }
        throw new ServiceException("Shipping address " + dto.getAddressId() + " already exists");
    }

    protected ShippingAddressDTO updateAddress(String json) throws ServiceException {
        try {
            ShippingAddressDTO dto = this.checkInputData(json);
            this.getById(dto.getAddressId());
            return shippingAddressRepository.save(dto);
        } catch (ServiceException e) {
            throw e;
        }
    }

    @Override
    public String getByIdToJson(int addressId) throws ServiceException {
        return SerializersCatalog.getInstance(Serializers.SHIPPINGADDRESS_JSON)
                .serialize(this.getById(addressId));
    }

    @Override
    public String addFromJson(String json) throws ServiceException {
        this.serializer = SerializersCatalog.getInstance(Serializers.SHIPPINGADDRESS_JSON);
        return serializer.serialize(this.newAddress(json));
    }

    @Override
    public String updateOneFromJson(String json) throws ServiceException {
        this.serializer = SerializersCatalog.getInstance(Serializers.SHIPPINGADDRESS_JSON);
        return serializer.serialize(this.updateAddress(json));
    }

    @Override
    public void deleteById(int addressId) throws ServiceException {
        this.getById(addressId);
        shippingAddressRepository.deleteById(addressId);
    }
}
