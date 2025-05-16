package com.example.Models.Motherboard.MAPPERS;

import com.example.Exceptions.BuildException;
import com.example.Models.Motherboard.DTO.MotherBoardDTO;
import com.example.Models.Motherboard.Entity.MotherBoard;

public class MotherBoardMapper {

    public static MotherBoard motherBoardFromDTO(MotherBoardDTO dto) throws BuildException {
        return MotherBoard.getInstance(
            dto.getName(),
            dto.getDescription(),
            dto.getPrice(),
            dto.getStockQuantity(),
            dto.getRating(),
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
    }

    public static MotherBoardDTO dtoFromMotherBoard(MotherBoard mb) {
        return new MotherBoardDTO(
            mb.getProductId(),
            mb.getName(),
            mb.getDescription(),
            mb.getPrice(),
            mb.getStockQuantity(),
            mb.getRating(),
            mb.getImageUrl(),
            mb.getBrand(),
            mb.getCpu(),
            mb.getMemory(),
            mb.getStorage(),
            mb.getFactorForm(),
            mb.getSocket(),
            mb.getChipset(),
            mb.getMemoryType(),
            mb.getMemorySlots(),
            mb.getMaxMemory(),
            mb.getHigh(),
            mb.getWidth(),
            mb.getLength(),
            mb.getWeight(),
            mb.getFragile()
        );
    }
}
