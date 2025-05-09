package com.example.Models.GraphicCard.MAPPER;

import com.example.Exceptions.BuildException;
import com.example.Models.GraphicCard.DTO.GraphicCardDTO;
import com.example.Models.GraphicCard.Entity.GraphicCard;

public class GraphicCardMapper {

    public static GraphicCard graphicCardFromDTO(GraphicCardDTO dto) throws BuildException {
        return GraphicCard.getInstance(
                dto.getName(),
                dto.getDescription(),
                dto.getPrice(),
                dto.getStockQuantity(),
                dto.getRating(),
                dto.getBrand(),
                dto.getColor(),
                dto.getMemory(),
                dto.getMemoryType(),
                dto.getRecommendedPowerSupply(),
                dto.getCoreClock(),
                dto.getBoostClock(),
                dto.getTdp(),
                dto.getInterfaceConnection(),
                dto.getHigh(),
                dto.getWidth(),
                dto.getLength(),
                dto.getWeight(),
                dto.isFragile()
        );
    }

    public static GraphicCardDTO dtoFromGraphicCard(GraphicCard graphicCard) {
        return new GraphicCardDTO(
                graphicCard.getName(),
                graphicCard.getDescription(),
                graphicCard.getPrice(),
                graphicCard.getStockQuantity(),
                graphicCard.getRating(),
                graphicCard.getBrand(),
                graphicCard.getColor(),
                graphicCard.getMemory(),
                graphicCard.getMemoryType(),
                graphicCard.getRecommendedPowerSupply(),
                graphicCard.getCoreClock(),
                graphicCard.getBoostClock(),
                graphicCard.getTdp(),
                graphicCard.getInterfaceConnection(),
                graphicCard.getHigh(),
                graphicCard.getWidth(),
                graphicCard.getLength(),
                graphicCard.getWeight(),
                graphicCard.getFragile()
        );
    }
}
