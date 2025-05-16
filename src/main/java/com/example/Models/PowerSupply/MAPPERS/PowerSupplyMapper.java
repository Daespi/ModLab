// package com.example.Models.PowerSupply.MAPPERS;

// import com.example.Exceptions.BuildException;
// import com.example.Models.PowerSupply.DTO.PowerSupplyDTO;
// import com.example.Models.PowerSupply.Entity.PowerSupply;

// public class PowerSupplyMapper {

//     public static PowerSupply powerSupplyFromDTO(PowerSupplyDTO dto) throws BuildException {
//         return PowerSupply.getInstance(
//             dto.getName(),
//             dto.getDescription(),
//             dto.getPrice(),
//             dto.getStockQuantity(),
//             dto.getRating(),
//             dto.getBrand(),
//             dto.getModel(),
//             dto.getColor(),
//             dto.getTotalPower(),
//             dto.getConnectors(),
//             dto.getFrecuency(),
//             dto.getHigh(),
//             dto.getWidth(),
//             dto.getLength(),
//             dto.getWeight(),
//             dto.getFragile()
//         );
//     }

//     public static PowerSupplyDTO dtoFromPowerSupply(PowerSupply ps) {
//         return new PowerSupplyDTO(
//             ps.getProductId(),
//             ps.getName(),
//             ps.getDescription(),
//             ps.getPrice(),
//             ps.getStockQuantity(),
//             ps.getRating(),
//             ps.getImageUrl(),
//             ps.getBrand(),
//             ps.getModel(),
//             ps.getColor(),
//             ps.getTotalPower(),
//             ps.getConnectors(),
//             ps.getFrecuency(),
//             ps.getHigh(),
//             ps.getWidth(),
//             ps.getLength(),
//             ps.getWeight(),
//             ps.getFragile()
//         );
//     }
// }
