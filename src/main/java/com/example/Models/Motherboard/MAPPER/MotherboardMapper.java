package com.example.Models.Motherboard.MAPPER;

import com.example.Exceptions.BuildException;
import com.example.Models.Motherboard.DTO.MotherboardDTO;
import com.example.Models.Motherboard.Entity.Motherboard;

public class MotherboardMapper {

    public static Motherboard motherboardFromDTO(MotherboardDTO dto) throws BuildException {
        return Motherboard.getInstance(
                dto.getName(),
                dto.getDescription(),
                dto.getPrice(),
                dto.getStockQuantity(),
                dto.getRating(),
                dto.getBrand(),
                dto.isCpu(),
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
                dto.isFragile()
        );
    }

    public static MotherboardDTO dtoFromMotherboard(Motherboard motherboard) {
        return new MotherboardDTO(
                motherboard.getName(),
                motherboard.getDescription(),
                motherboard.getPrice(),
                motherboard.getStockQuantity(),
                motherboard.getRating(),
                motherboard.getBrand(),
                motherboard.getCpu(),
                motherboard.getMemory(),
                motherboard.getStorage(),
                motherboard.getFactorForm(),
                motherboard.getSocket(),
                motherboard.getChipset(),
                motherboard.getMemoryType(),
                motherboard.getMemorySlots(),
                motherboard.getMaxMemory(),
                motherboard.getHigh(),
                motherboard.getWidth(),
                motherboard.getLength(),
                motherboard.getWeight(),
                motherboard.getFragile()
        );
    }
}
