package com.example.Models.HardDrive.Appservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Exceptions.BuildException;
import com.example.Exceptions.ServiceException;
import com.example.Models.HardDrive.DTO.HardDriveDTO;
import com.example.Models.HardDrive.MAPPERS.HardDriveMapper;
import com.example.Models.HardDrive.Persistence.HardDriveRepository;
import com.example.sharedkernel.appservices.serializers.Serializer;
import com.example.sharedkernel.appservices.serializers.Serializers;
import com.example.sharedkernel.appservices.serializers.SerializersCatalog;

@Service
public class HardDriveServicesImpl implements HardDriveServices {

    @Autowired
    private HardDriveRepository hardDriveRepository;

    private final Serializer<HardDriveDTO> serializer = SerializersCatalog.getInstance(Serializers.HardDrive_JSON);

    protected HardDriveDTO getDTO(String productId) {
        return hardDriveRepository.findById(productId).orElse(null);
    }

    protected HardDriveDTO getById(String productId) throws ServiceException {
        HardDriveDTO dto = this.getDTO(productId);
        if (dto == null) {
            throw new ServiceException("Hard Drive with ID " + productId + " not found.");
        }
        return dto;
    }

    protected HardDriveDTO checkInputData(String json) throws ServiceException {
        try {
            HardDriveDTO dto = this.serializer.deserialize(json, HardDriveDTO.class);
            HardDriveMapper.hardDriveFromDTO(dto); // Validación lógica
            return dto;
        } catch (BuildException e) {
            throw new ServiceException("Error in Hard Drive data: " + e.getMessage());
        }
    }

    protected HardDriveDTO newHardDrive(String json) throws ServiceException {
        HardDriveDTO dto = this.checkInputData(json);
        return hardDriveRepository.save(dto);
    }

    protected HardDriveDTO updateHardDrive(String productId, String json) throws ServiceException {
        this.getById(productId); // Verificación
        HardDriveDTO dto = this.checkInputData(json);
        dto = new HardDriveDTO(
            productId,
            dto.getName(),
            dto.getDescription(),
            dto.getPrice(),
            dto.getStockQuantity(),
            dto.getRating(),
            dto.getImageUrls(),
            dto.getBrand(),
            dto.getStorageInterface(),
            dto.isSsd(),
            dto.getRandomReading(),
            dto.getCapacity(),
            dto.getWriteSpeed(),
            dto.getFormFactor(),
            dto.getHigh(),
            dto.getWidth(),
            dto.getLength(),
            dto.getWeight(),
            dto.getFragile()
        );
        return hardDriveRepository.save(dto);
    }

    @Override
    public String getByIdToJson(String productId) throws ServiceException {
        return serializer.serialize(this.getById(productId));
    }

    @Override
    public String addFromJson(String hardDriveJson) throws ServiceException {
        return serializer.serialize(this.newHardDrive(hardDriveJson));
    }

    @Override
    public String updateOneFromJson(String productId, String hardDriveJson) throws ServiceException {
        return serializer.serialize(this.updateHardDrive(productId, hardDriveJson));
    }

    @Override
    public void deleteById(String productId) throws ServiceException {
        this.getById(productId); // Verificación
        hardDriveRepository.deleteById(productId);
    }
}
