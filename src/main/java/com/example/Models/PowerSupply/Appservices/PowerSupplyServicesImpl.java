package com.example.Models.PowerSupply.Appservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Exceptions.BuildException;
import com.example.Exceptions.ServiceException;
import com.example.Models.PowerSupply.DTO.PowerSupplyDTO;
import com.example.Models.PowerSupply.MAPPERS.PowerSupplyMapper;
import com.example.Models.PowerSupply.Persistence.PowerSupplyRepository;
import com.example.sharedkernel.appservices.serializers.Serializer;
import com.example.sharedkernel.appservices.serializers.Serializers;
import com.example.sharedkernel.appservices.serializers.SerializersCatalog;

@Service
public class PowerSupplyServicesImpl implements PowerSupplyServices {

    @Autowired
    private PowerSupplyRepository powerSupplyRepository;

    private final Serializer<PowerSupplyDTO> serializer = SerializersCatalog.getInstance(Serializers.PowerSupply_JSON);

    protected PowerSupplyDTO getDTO(String productId) {
        return powerSupplyRepository.findById(productId).orElse(null);
    }

    protected PowerSupplyDTO getById(String productId) throws ServiceException {
        PowerSupplyDTO dto = this.getDTO(productId);
        if (dto == null) {
            throw new ServiceException("Power Supply with ID " + productId + " not found.");
        }
        return dto;
    }

    protected PowerSupplyDTO checkInputData(String json) throws ServiceException {
        try {
            PowerSupplyDTO dto = this.serializer.deserialize(json, PowerSupplyDTO.class);
            PowerSupplyMapper.powerSupplyFromDTO(dto); // Validación lógica
            return dto;
        } catch (BuildException e) {
            throw new ServiceException("Error in Power Supply data: " + e.getMessage());
        }
    }

    protected PowerSupplyDTO newPowerSupply(String json) throws ServiceException {
        PowerSupplyDTO dto = this.checkInputData(json);
        return powerSupplyRepository.save(dto);
    }

    protected PowerSupplyDTO updatePowerSupply(String productId, String json) throws ServiceException {
        this.getById(productId); // Verificación
        PowerSupplyDTO dto = this.checkInputData(json);
        dto = new PowerSupplyDTO(
            productId,
            dto.getName(),
            dto.getDescription(),
            dto.getPrice(),
            dto.getStockQuantity(),
            dto.getRating(),
            dto.getImageUrls(),
            dto.getBrand(),
            dto.getModel(),
            dto.getColor(),
            dto.getTotalPower(),
            dto.getConnectors(),
            dto.getFrecuency(),
            dto.getHigh(),
            dto.getWidth(),
            dto.getLength(),
            dto.getWeight(),
            dto.getFragile()
        );
        return powerSupplyRepository.save(dto);
    }

    @Override
    public String getByIdToJson(String productId) throws ServiceException {
        return serializer.serialize(this.getById(productId));
    }

    @Override
    public String addFromJson(String powerSupplyJson) throws ServiceException {
        return serializer.serialize(this.newPowerSupply(powerSupplyJson));
    }

    @Override
    public String updateOneFromJson(String productId, String powerSupplyJson) throws ServiceException {
        return serializer.serialize(this.updatePowerSupply(productId, powerSupplyJson));
    }

    @Override
    public void deleteById(String productId) throws ServiceException {
        this.getById(productId); // Verificación
        powerSupplyRepository.deleteById(productId);
    }
}
