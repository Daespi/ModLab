package com.example.Models.PowerSupply.MAPPER;

import java.util.HashSet;
import java.util.List;

import com.example.Exceptions.BuildException;
import com.example.Models.PowerSupply.DTO.PowerSupplyDTO;
import com.example.Models.PowerSupply.Entity.PowerSupply;

public class PowersupplyMapper {

    public static PowerSupply powerSupplyFromDTO(PowerSupplyDTO dto) throws BuildException {
        // Convertir de PowerSupplyDTO a PowerSupply (entidad)
        PowerSupply powerSupply = PowerSupply.getInstance(
                dto.getName(),
                dto.getDescription(),
                dto.getPrice(),
                dto.getStockQuantity(),
                dto.getRating(),
                dto.getBrand(),
                dto.getModel(),
                dto.getColor(),
                dto.getTotalPower(),
                String.join(",", dto.getConnectors()), // Se transforma el Set a String
                dto.getFrecuency(),
                dto.getHigh(),
                dto.getWidth(),
                dto.getLength(),
                dto.getWeight(),
                dto.isFragile()
        );
        return powerSupply;
    }

    public static PowerSupplyDTO dtoFromPowerSupply(PowerSupply powerSupply) {
        // Convertir de PowerSupply (entidad) a PowerSupplyDTO
        return new PowerSupplyDTO(
                powerSupply.getName(),
                powerSupply.getDescription(),
                powerSupply.getPrice(),
                powerSupply.getStockQuantity(),
                powerSupply.getRating(),
                powerSupply.getBrand(),
                powerSupply.getModel(),
                powerSupply.getColor(),
                powerSupply.getTotalPower(),
                powerSupply.getConnectors() != null ? new HashSet<>(List.of(powerSupply.getConnectors().split(","))) : new HashSet<>(),
                powerSupply.getFrecuency(),
                powerSupply.getHigh(),
                powerSupply.getWidth(),
                powerSupply.getLength(),
                powerSupply.getWeight(),
                powerSupply.getFragile()
        );
    }
}
