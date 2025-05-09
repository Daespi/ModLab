package com.example.Models.Tower.MAPPER;

import java.util.Set;

import com.example.Exceptions.BuildException;
import com.example.Models.Tower.DTO.TowerDTO;
import com.example.Models.Tower.Entity.Tower;

public class TowerMapper {

    // Mapea de TowerDTO a Tower (Entidad)
    public static Tower towerFromDTO(TowerDTO dto) throws BuildException {
        // Convierte el Set de conectores en una cadena de texto separada por comas
        String connectors = String.join(",", dto.getConnectors());
        
        return Tower.getInstance(
                dto.getName(),
                dto.getDescription(),
                dto.getPrice(),
                dto.getStockQuantity(),
                dto.getRating(),
                dto.getBrand(),
                dto.getFormFactor(),
                dto.getColor(),
                connectors,
                dto.getMaterial(),
                dto.getFanSupport(),
                dto.getMaxGpuLength(),
                dto.getMaxCpuCoolerHeight(),
                dto.getHigh(),
                dto.getWidth(),
                dto.getLength(),
                dto.getWeight(),
                dto.isFragile()
        );
    }

    // Mapea de Tower (Entidad) a TowerDTO
    public static TowerDTO dtoFromTower(Tower tower) {
        // Convierte la cadena de conectores en un Set
        Set<String> connectors = Set.of(tower.getConnectors().split(","));
        
        return new TowerDTO(
                tower.getName(),
                tower.getDescription(),
                tower.getPrice(),
                tower.getStockQuantity(),
                tower.getRating(),
                tower.getBrand(),
                tower.getFormFactor(),
                tower.getColor(),
                connectors,
                tower.getMaterial(),
                tower.getFanSupport(),
                tower.getMaxGpuLength(),
                tower.getMaxCpuCoolerHeight(),
                tower.getHigh(),
                tower.getWidth(),
                tower.getLength(),
                tower.getWeight(),
                tower.getFragile()
        );
    }
}
