package com.example.Models.CPU.MAPPERS;

import com.example.Exceptions.BuildException;
import com.example.Models.CPU.DTO.CPUDTO;
import com.example.Models.CPU.Entity.CPU;

public class CPUMapper {

    public static CPU cpuFromDTO(CPUDTO dto) throws BuildException {
        return CPU.getInstance(
            dto.getName(),
            dto.getDescription(),
            dto.getPrice(),
            dto.getStockQuantity(),
            dto.getRating(),
            dto.getBrand(),
            dto.getModel(),
            dto.getProcessorCore(),
            dto.getNumberThreads(),
            dto.getBaseClock(),
            dto.getFrecuency(),
            dto.getCacheMemory(),
            dto.getTdp(),
            dto.getSocket(),
            dto.getLithography(),
            dto.isHasIntegratedGraphics(),
            dto.getHigh(),
            dto.getWidth(),
            dto.getLength(),
            dto.getWeight(),
            dto.getFragile()
        );
    }

    public static CPUDTO dtoFromCPU(CPU cpu) {
        return new CPUDTO(
            cpu.getProductId(),
            cpu.getName(),
            cpu.getDescription(),
            cpu.getPrice(),
            cpu.getStockQuantity(),
            cpu.getRating(),
            cpu.getImageUrl(),
            cpu.getBrand(),
            cpu.getModel(),
            cpu.getProcessorCore(),
            cpu.getNumberThreads(),
            cpu.getBaseClock(),
            cpu.getFrecuency(),
            cpu.getCacheMemory(),
            cpu.getTdp(),
            cpu.getSocket(),
            cpu.getLithography(),
            cpu.isHasIntegratedGraphics(),
            cpu.getHigh(),
            cpu.getWidth(),
            cpu.getLength(),
            cpu.getWeight(),
            cpu.getFragile()
        );
    }
}
