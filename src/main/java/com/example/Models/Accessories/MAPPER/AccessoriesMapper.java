package com.example.Models.Accessories.MAPPER;

import com.example.Exceptions.BuildException;
import com.example.Models.Accessories.DTO.AccessoriesDTO;
import com.example.Models.Accessories.Entity.Accessories;

public class AccessoriesMapper {

    public static Accessories accessoriesFromDTO(AccessoriesDTO dto) throws BuildException {
        return Accessories.getInstance(
                dto.getName(),
                dto.getDescription(),
                dto.getPrice(),
                dto.getStockQuantity(),
                dto.getRating(),
                dto.getBrand(),
                dto.getColor(),
                dto.getMaterial(),
                dto.getHigh(),
                dto.getWidth(),
                dto.getLength(),
                dto.getWeight(),
                dto.isFragile()
        );
    }

    public static AccessoriesDTO dtoFromAccessories(Accessories accessories) {
        return new AccessoriesDTO(
                accessories.getName(),
                accessories.getDescription(),
                accessories.getPrice(),
                accessories.getStockQuantity(),
                accessories.getRating(),
                accessories.getBrand(),
                accessories.getColor(),
                accessories.getMaterial(),
                accessories.getHigh(),
                accessories.getWidth(),
                accessories.getLength(),
                accessories.getWeight(),
                accessories.getFragile()
        );
    }
}
