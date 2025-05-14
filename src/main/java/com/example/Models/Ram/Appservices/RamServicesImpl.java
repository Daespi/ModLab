package com.example.Models.Ram.Appservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Exceptions.BuildException;
import com.example.Exceptions.ServiceException;
import com.example.Models.Ram.DTO.RamDTO;
import com.example.Models.Ram.MAPPERS.RamMapper;
import com.example.Models.Ram.Persistence.RamRepository;
import com.example.sharedkernel.appservices.serializers.Serializer;
import com.example.sharedkernel.appservices.serializers.Serializers;
import com.example.sharedkernel.appservices.serializers.SerializersCatalog;

@Service
public class RamServicesImpl implements RamServices {

    @Autowired
    private RamRepository ramRepository;

    private final Serializer<RamDTO> serializer = SerializersCatalog.getInstance(Serializers.Ram_JSON);

    protected RamDTO getDTO(String productId) {
        return ramRepository.findById(productId).orElse(null);
    }

    protected RamDTO getById(String productId) throws ServiceException {
        RamDTO dto = this.getDTO(productId);
        if (dto == null) {
            throw new ServiceException("RAM with ID " + productId + " not found.");
        }
        return dto;
    }

    protected RamDTO checkInputData(String json) throws ServiceException {
        try {
            RamDTO dto = this.serializer.deserialize(json, RamDTO.class);
            RamMapper.ramFromDTO(dto); // Validación lógica
            return dto;
        } catch (BuildException e) {
            throw new ServiceException("Error in RAM data: " + e.getMessage());
        }
    }

    protected RamDTO newRam(String json) throws ServiceException {
        RamDTO dto = this.checkInputData(json);
        return ramRepository.save(dto);
    }

    protected RamDTO updateRam(String productId, String json) throws ServiceException {
        this.getById(productId); // Verificación
        RamDTO dto = this.checkInputData(json);
        dto = new RamDTO(
            productId,
            dto.getName(),
            dto.getDescription(),
            dto.getPrice(),
            dto.getStockQuantity(),
            dto.getRating(),
            dto.getImageUrls(),
            dto.getBrand(),
            dto.getLatency(),
            dto.getTypeDdr(),
            dto.getInternalMemory(),
            dto.getMemorySpeed(),
            dto.getLed(),
            dto.getMemorySize(),
            dto.getNumberOfModules(),
            dto.getVoltage(),
            dto.getHigh(),
            dto.getWidth(),
            dto.getLength(),
            dto.getWeight(),
            dto.getFragile()
        );
        return ramRepository.save(dto);
    }

    @Override
    public String getByIdToJson(String productId) throws ServiceException {
        return serializer.serialize(this.getById(productId));
    }

    @Override
    public String addFromJson(String ramJson) throws ServiceException {
        return serializer.serialize(this.newRam(ramJson));
    }

    @Override
    public String updateOneFromJson(String productId, String ramJson) throws ServiceException {
        return serializer.serialize(this.updateRam(productId, ramJson));
    }

    @Override
    public void deleteById(String productId) throws ServiceException {
        this.getById(productId); // Verificación
        ramRepository.deleteById(productId);
    }
}
