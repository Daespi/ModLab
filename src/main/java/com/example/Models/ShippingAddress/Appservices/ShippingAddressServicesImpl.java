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
            ShippingAddressMapper.addressFromDTO(dto); // Validación lógica
            return dto;
        } catch (BuildException e) {
            throw new ServiceException("Error in the input shipping address data: " + e.getMessage());
        }
    }

    protected ShippingAddressDTO newAddress(String json) throws ServiceException {
        ShippingAddressDTO dto = this.checkInputData(json);
        return shippingAddressRepository.save(dto);
    }

    protected ShippingAddressDTO updateAddress(String json) throws ServiceException {
        ShippingAddressDTO dto = this.checkInputData(json);
        this.getById(dto.getAddressId());
        return shippingAddressRepository.save(dto);
    }

    // ✅ NUEVO MÉTODO para actualizar con ID externo
    protected ShippingAddressDTO updateAddressWithId(int addressId, String json) throws ServiceException {
        ShippingAddressDTO dto = this.checkInputData(json);
        this.getById(addressId);
        // Forzamos que el ID del DTO sea el correcto
        ShippingAddressDTO updatedDto = new ShippingAddressDTO(
            addressId,
            dto.getUserId(),
            dto.getAddress(),
            dto.getZipCode(),
            dto.getCity(),
            dto.getState(),
            dto.getCountry()
        );
        return shippingAddressRepository.save(updatedDto);
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

    // ✅ Método público que llamas desde el controlador
    public String updateOneFromJsonWithId(int addressId, String json) throws ServiceException {
        this.serializer = SerializersCatalog.getInstance(Serializers.SHIPPINGADDRESS_JSON);
        return serializer.serialize(this.updateAddressWithId(addressId, json));
    }

    @Override
    public void deleteById(int addressId) throws ServiceException {
        this.getById(addressId);
        shippingAddressRepository.deleteById(addressId);
    }
}