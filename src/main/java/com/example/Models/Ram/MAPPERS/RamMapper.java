// package com.example.Models.Ram.MAPPERS;

// import com.example.Exceptions.BuildException;
// import com.example.Models.Ram.DTO.RamDTO;
// import com.example.Models.Ram.Entity.Ram;

// public class RamMapper {

//     public static Ram ramFromDTO(RamDTO dto) throws BuildException {
//         return Ram.getInstance(
//             dto.getName(),
//             dto.getDescription(),
//             dto.getPrice(),
//             dto.getStockQuantity(),
//             dto.getRating(),
//             dto.getBrand(),
//             dto.getLatency(),
//             dto.getTypeDdr(),
//             dto.getInternalMemory(),
//             dto.getMemorySpeed(),
//             dto.getLed(),
//             dto.getMemorySize(),
//             dto.getNumberOfModules(),
//             dto.getVoltage(),
//             dto.getHigh(),
//             dto.getWidth(),
//             dto.getLength(),
//             dto.getWeight(),
//             dto.getFragile()
//         );
//     }

//     public static RamDTO dtoFromRam(Ram ram) {
//         return new RamDTO(
//             ram.getProductId(),
//             ram.getName(),
//             ram.getDescription(),
//             ram.getPrice(),
//             ram.getStockQuantity(),
//             ram.getRating(),
//             ram.getImageUrl(),
//             ram.getBrand(),
//             ram.getLatency(),
//             ram.getTypeDdr(),
//             ram.getInternalMemory(),
//             ram.getMemorySpeed(),
//             ram.getLed(),
//             ram.getMemorySize(),
//             ram.getNumberOfModules(),
//             ram.getVoltage(),
//             ram.getHigh(),
//             ram.getWidth(),
//             ram.getLength(),
//             ram.getWeight(),
//             ram.getFragile()
//         );
//     }
// }
