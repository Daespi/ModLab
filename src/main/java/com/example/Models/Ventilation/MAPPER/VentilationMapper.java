package com.example.Models.Ventilation.MAPPER;

import com.example.Exceptions.BuildException;
import com.example.Models.Ventilation.DTO.VentilationDTO;
import com.example.Models.Ventilation.Entity.Ventilation;

public class VentilationMapper {

    // Mapea de VentilationDTO a Ventilation (Entidad)
    public static Ventilation ventilationFromDTO(VentilationDTO dto) throws BuildException {
        return Ventilation.getInstance(
                dto.getName(),
                dto.getDescription(),
                dto.getPrice(),
                dto.getStockQuantity(),
                dto.getRating(),
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
    }

    // Mapea de Ventilation (Entidad) a VentilationDTO
    public static VentilationDTO dtoFromVentilation(Ventilation ventilation) {
        return new VentilationDTO(
                ventilation.getName(),
                ventilation.getDescription(),
                ventilation.getPrice(),
                ventilation.getStockQuantity(),
                ventilation.getRating(),
                ventilation.getBrand(),
                ventilation.isLeds(),
                ventilation.getColor(),
                ventilation.getMaxAirflow(),
                ventilation.getRotationSpeed(),
                ventilation.getNoiseLevel(),
                ventilation.getBearingType(),
                ventilation.getInputVoltage(),
                ventilation.getHigh(),
                ventilation.getWidth(),
                ventilation.getLength(),
                ventilation.getWeight(),
                ventilation.getFragile()
        );
    }
}
