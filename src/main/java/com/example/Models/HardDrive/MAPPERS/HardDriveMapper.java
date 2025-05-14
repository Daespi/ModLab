package com.example.Models.HardDrive.MAPPERS;

import com.example.Exceptions.BuildException;
import com.example.Models.HardDrive.DTO.HardDriveDTO;
import com.example.Models.HardDrive.Entity.HardDrive;

public class HardDriveMapper {

    public static HardDrive hardDriveFromDTO(HardDriveDTO dto) throws BuildException {
        return HardDrive.getInstance(
            dto.getName(),
            dto.getDescription(),
            dto.getPrice(),
            dto.getStockQuantity(),
            dto.getRating(),
            dto.getBrand(),
            dto.getStorageInterface(),
            dto.isSsd() ? "SSD" : "HDD", // Si usas tipo como string, puedes adaptarlo aquí
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
    }

    public static HardDriveDTO dtoFromHardDrive(HardDrive hardDrive) {
        return new HardDriveDTO(
            hardDrive.getProductId(),
            hardDrive.getName(),
            hardDrive.getDescription(),
            hardDrive.getPrice(),
            hardDrive.getStockQuantity(),
            hardDrive.getRating(),
            hardDrive.getImageUrl(),
            hardDrive.getBrand(),
            hardDrive.getStorageInterface(),
            hardDrive.isSsd(),
            hardDrive.getRandomReading(),
            hardDrive.getCapacity(),
            hardDrive.getWriteSpeed(),
            hardDrive.getFormFactor(),
            hardDrive.getWidth(),
            hardDrive.getHigh(),
            hardDrive.getLength(),
            hardDrive.getWeight(),
            hardDrive.getFragile()
        );
    }
}
