package com.example.Models.Motherboard.Appservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Exceptions.BuildException;
import com.example.Exceptions.ServiceException;
import com.example.Models.Motherboard.DTO.MotherBoardDTO;
import com.example.Models.Motherboard.MAPPERS.MotherBoardMapper;
import com.example.Models.Motherboard.Persistence.MotherBoardRepository;
import com.example.sharedkernel.appservices.serializers.Serializer;
import com.example.sharedkernel.appservices.serializers.Serializers;
import com.example.sharedkernel.appservices.serializers.SerializersCatalog;

@Service
public class MotherBoardServicesImpl implements MotherBoardServices {

    @Autowired
    private MotherBoardRepository motherBoardRepository;

    private final Serializer<MotherBoardDTO> serializer = SerializersCatalog.getInstance(Serializers.Motherboard_JSON);

    protected MotherBoardDTO getDTO(String productId) {
        return motherBoardRepository.findById(productId).orElse(null);
    }

    protected MotherBoardDTO getById(String productId) throws ServiceException {
        MotherBoardDTO dto = this.getDTO(productId);
        if (dto == null) {
            throw new ServiceException("MotherBoard with ID " + productId + " not found.");
        }
        return dto;
    }

    protected MotherBoardDTO checkInputData(String json) throws ServiceException {
        try {
            MotherBoardDTO dto = this.serializer.deserialize(json, MotherBoardDTO.class);
            MotherBoardMapper.motherBoardFromDTO(dto); // Validación lógica
            return dto;
        } catch (BuildException e) {
            throw new ServiceException("Error in MotherBoard data: " + e.getMessage());
        }
    }

    protected MotherBoardDTO newMotherBoard(String json) throws ServiceException {
        MotherBoardDTO dto = this.checkInputData(json);
        return motherBoardRepository.save(dto);
    }

    protected MotherBoardDTO updateMotherBoard(String productId, String json) throws ServiceException {
        this.getById(productId); // Verificación
        MotherBoardDTO dto = this.checkInputData(json);
        dto = new MotherBoardDTO(
            productId,
            dto.getName(),
            dto.getDescription(),
            dto.getPrice(),
            dto.getStockQuantity(),
            dto.getRating(),
            dto.getImageUrls(),
            dto.getBrand(),
            dto.getCpu(),
            dto.getMemory(),
            dto.getStorage(),
            dto.getFactorForm(),
            dto.getSocket(),
            dto.getChipset(),
            dto.getMemoryType(),
            dto.getMemorySlots(),
            dto.getMaxMemory(),
            dto.getHigh(),
            dto.getWidth(),
            dto.getLength(),
            dto.getWeight(),
            dto.getFragile()
        );
        return motherBoardRepository.save(dto);
    }

    @Override
    public String getByIdToJson(String productId) throws ServiceException {
        return serializer.serialize(this.getById(productId));
    }

    @Override
    public String addFromJson(String motherBoardJson) throws ServiceException {
        return serializer.serialize(this.newMotherBoard(motherBoardJson));
    }

    @Override
    public String updateOneFromJson(String productId, String motherBoardJson) throws ServiceException {
        return serializer.serialize(this.updateMotherBoard(productId, motherBoardJson));
    }

    @Override
    public void deleteById(String productId) throws ServiceException {
        this.getById(productId); // Verificación
        motherBoardRepository.deleteById(productId);
    }
}