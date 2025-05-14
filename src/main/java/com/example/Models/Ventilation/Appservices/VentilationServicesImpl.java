package com.example.Models.Ventilation.Appservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Exceptions.BuildException;
import com.example.Exceptions.ServiceException;
import com.example.Models.Ventilation.DTO.VentilationDTO;
import com.example.Models.Ventilation.MAPPERS.VentilationMapper;
import com.example.Models.Ventilation.Persistence.VentilationRepository;
import com.example.sharedkernel.appservices.serializers.Serializer;
import com.example.sharedkernel.appservices.serializers.Serializers;
import com.example.sharedkernel.appservices.serializers.SerializersCatalog;

@Service
public class VentilationServicesImpl implements VentilationServices {

    @Autowired
    private VentilationRepository ventilationRepository;

    private final Serializer<VentilationDTO> serializer = SerializersCatalog.getInstance(Serializers.Ventilation_JSON);

    protected VentilationDTO getDTO(String productId) {
        return ventilationRepository.findById(productId).orElse(null);
    }

    protected VentilationDTO getById(String productId) throws ServiceException {
        VentilationDTO dto = this.getDTO(productId);
        if (dto == null) {
            throw new ServiceException("Ventilation with ID " + productId + " not found.");
        }
        return dto;
    }

    protected VentilationDTO checkInputData(String json) throws ServiceException {
        try {
            VentilationDTO dto = this.serializer.deserialize(json, VentilationDTO.class);
            VentilationMapper.ventilationFromDTO(dto); // Validación lógica
            return dto;
        } catch (BuildException e) {
            throw new ServiceException("Error in Ventilation data: " + e.getMessage());
        }
    }

    protected VentilationDTO newVentilation(String json) throws ServiceException {
        VentilationDTO dto = this.checkInputData(json);
        return ventilationRepository.save(dto);
    }

    protected VentilationDTO updateVentilation(String productId, String json) throws ServiceException {
        this.getById(productId); // Verificación
        VentilationDTO dto = this.checkInputData(json);
        dto = new VentilationDTO(
            productId,
            dto.getName(),
            dto.getDescription(),
            dto.getPrice(),
            dto.getStockQuantity(),
            dto.getRating(),
            dto.getImageUrls(),
            dto.getBrand(),
            dto.isLeds(),
            dto.getColor(),
            dto.getMaxAirflow(),
            dto.getRotationSpeed(),
            dto.getNoiseLevel(),
            dto.getBearingType(),
            dto.getInputVoltage(),
            dto.getHigh(),
            dto.getWidth(),
            dto.getLength(),
            dto.getWeight(),
            dto.isFragile()
        );
        return ventilationRepository.save(dto);
    }

    @Override
    public String getByIdToJson(String productId) throws ServiceException {
        return serializer.serialize(this.getById(productId));
    }

    @Override
    public String addFromJson(String ventilationJson) throws ServiceException {
        return serializer.serialize(this.newVentilation(ventilationJson));
    }

    @Override
    public String updateOneFromJson(String productId, String ventilationJson) throws ServiceException {
        return serializer.serialize(this.updateVentilation(productId, ventilationJson));
    }

    @Override
    public void deleteById(String productId) throws ServiceException {
        this.getById(productId); // Verificación
        ventilationRepository.deleteById(productId);
    }
}
