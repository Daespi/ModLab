package com.example.Models.Tower.MAPPERS;

import com.example.Exceptions.BuildException;
import com.example.Models.Tower.DTO.TowerDTO;
import com.example.Models.Tower.Entity.Tower;

public class TowerMapper {

    public static Tower towerFromDTO(TowerDTO dto) throws BuildException {
        return Tower.getInstance(
            dto.getName(),
            dto.getDescription(),
            dto.getPrice(),
            dto.getStockQuantity(),
            dto.getRating(),
            dto.getBrand(),
            dto.getFormFactor(),
            dto.getColor(),
            dto.getConnectors(),
            dto.getMaterial(),
            dto.getFanSupport(),
            dto.getMaxGpuLength(),
            dto.getMaxCpuCoolerHeight(),
            dto.getHigh(),
            dto.getWidth(),
            dto.getLength(),
            dto.getWeight(),
            dto.getFragile()
        );
    }

    public static TowerDTO dtoFromTower(Tower tower) {
        return new TowerDTO(
            tower.getProductId(),
            tower.getName(),
            tower.getDescription(),
            tower.getPrice(),
            tower.getStockQuantity(),
            tower.getRating(),
            tower.getImageUrl(),
            tower.getBrand(),
            tower.getFormFactor(),
            tower.getColor(),
            tower.getConnectors(),
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
