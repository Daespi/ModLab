package com.example.Models.GraphicCard.Appservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Exceptions.BuildException;
import com.example.Exceptions.ServiceException;
import com.example.Models.GraphicCard.DTO.GraphicCardDTO;
import com.example.Models.GraphicCard.MAPPERS.GraphicCardMapper;
import com.example.Models.GraphicCard.Persistence.GraphicCardRepository;
import com.example.sharedkernel.appservices.serializers.Serializer;
import com.example.sharedkernel.appservices.serializers.Serializers;
import com.example.sharedkernel.appservices.serializers.SerializersCatalog;

@Service
public class GraphicCardServicesImpl implements GraphicCardServices {

    @Autowired
    private GraphicCardRepository graphicCardRepository;

    private final Serializer<GraphicCardDTO> serializer = SerializersCatalog.getInstance(Serializers.GraphicCard_JSON);

    protected GraphicCardDTO getDTO(String productId) {
        return graphicCardRepository.findById(productId).orElse(null);
    }

    protected GraphicCardDTO getById(String productId) throws ServiceException {
        GraphicCardDTO dto = this.getDTO(productId);
        if (dto == null) {
            throw new ServiceException("Graphic Card with ID " + productId + " not found.");
        }
        return dto;
    }

    protected GraphicCardDTO checkInputData(String json) throws ServiceException {
        try {
            GraphicCardDTO dto = this.serializer.deserialize(json, GraphicCardDTO.class);
            GraphicCardMapper.graphicCardFromDTO(dto); // Validación lógica
            return dto;
        } catch (BuildException e) {
            throw new ServiceException("Error in Graphic Card data: " + e.getMessage());
        }
    }

    protected GraphicCardDTO newGraphicCard(String json) throws ServiceException {
        GraphicCardDTO dto = this.checkInputData(json);
        return graphicCardRepository.save(dto);
    }

    protected GraphicCardDTO updateGraphicCard(String productId, String json) throws ServiceException {
        this.getById(productId); // Verificación
        GraphicCardDTO dto = this.checkInputData(json);
        dto = new GraphicCardDTO(
            productId,
            dto.getName(),
            dto.getDescription(),
            dto.getPrice(),
            dto.getStockQuantity(),
            dto.getRating(),
            dto.getImageUrls(),
            dto.getBrand(),
            dto.getColor(),
            dto.getMemory(),
            dto.getMemoryType(),
            dto.getRecommendedPowerSupply(),
            dto.getCoreClock(),
            dto.getBoostClock(),
            dto.getTdp(),
            dto.getInterfaceConnection(),
            dto.getWidth(),
            dto.getHigh(),
            dto.getLength(),
            dto.getWeight(),
            dto.isFragile()
        );
        return graphicCardRepository.save(dto);
    }

    @Override
    public String getByIdToJson(String productId) throws ServiceException {
        return serializer.serialize(this.getById(productId));
    }

    @Override
    public String addFromJson(String graphicCardJson) throws ServiceException {
        return serializer.serialize(this.newGraphicCard(graphicCardJson));
    }

    @Override
    public String updateOneFromJson(String productId, String graphicCardJson) throws ServiceException {
        return serializer.serialize(this.updateGraphicCard(productId, graphicCardJson));
    }

    @Override
    public void deleteById(String productId) throws ServiceException {
        this.getById(productId); // Verificación
        graphicCardRepository.deleteById(productId);
    }
}
