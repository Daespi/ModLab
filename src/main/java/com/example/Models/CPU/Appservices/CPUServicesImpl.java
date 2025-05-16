package com.example.Models.CPU.Appservices;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Exceptions.BuildException;
import com.example.Exceptions.ServiceException;
import com.example.Models.CPU.DTO.CPUDTO;
import com.example.Models.CPU.Entity.CPU;
import com.example.Models.CPU.MAPPERS.CPUMapper;
import com.example.Models.CPU.Persistence.CPURepository;
import com.example.sharedkernel.appservices.serializers.Serializer;
import com.example.sharedkernel.appservices.serializers.Serializers;
import com.example.sharedkernel.appservices.serializers.SerializersCatalog;

@Service
public class CPUServicesImpl implements CPUServices {

    @Autowired
    private CPURepository cpuRepository;

    private final Serializer<CPUDTO> serializer = SerializersCatalog.getInstance(Serializers.CPU_JSON);
    private final Serializer<List<CPUDTO>> listSerializer = SerializersCatalog.getInstance(Serializers.CPU_JSON_LIST);

    protected CPUDTO getDTO(String productId) {
        return cpuRepository.findById(productId).orElse(null);
    }



@Override
public String getAllToJson() throws ServiceException {
    List<CPUDTO> list = cpuRepository.findAll();
    if (list == null || list.isEmpty()) {
        throw new ServiceException("No se encontraron CPUs.");
    }
return listSerializer.serialize(list);
}




    protected CPUDTO getById(String productId) throws ServiceException {
        CPUDTO dto = this.getDTO(productId);
        if (dto == null) {
            throw new ServiceException("CPU con ID " + productId + " no encontrada.");
        }
        return dto;
    }

    protected CPUDTO checkInputData(String json) throws ServiceException {
        try {
            CPUDTO dto = this.serializer.deserialize(json, CPUDTO.class);
            CPUMapper.cpuFromDTO(dto); // validación lógica
            return dto;
        } catch (BuildException e) {
            throw new ServiceException("Error en los datos de la CPU: " + e.getMessage());
        }
    }

    protected CPUDTO newCPU(String json) throws ServiceException {
        CPUDTO dto = this.checkInputData(json);
        return cpuRepository.save(dto);
    }

    protected CPUDTO updateCPU(String productId, String json) throws ServiceException {
        this.getById(productId); // validación existencia
        CPUDTO dto = this.checkInputData(json);
        return cpuRepository.save(new CPUDTO(
            productId,
            dto.getName(),
            dto.getDescription(),
            dto.getPrice(),
            dto.getStockQuantity(),
            dto.getRating(),
            dto.getImageUrls(),
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
            dto.getWidth(),
            dto.getHigh(),
            dto.getLength(),
            dto.getWeight(),
            dto.getFragile()
        ));
    }

    @Override
    public String getByIdToJson(String productId) throws ServiceException {
        return serializer.serialize(this.getById(productId));
    }

    @Override
    public String addFromJson(String productJson) throws ServiceException {
        return serializer.serialize(this.newCPU(productJson));
    }

    @Override
    public String updateOneFromJson(String productId, String productJson) throws ServiceException {
        return serializer.serialize(this.updateCPU(productId, productJson));
    }

    @Override
    public void deleteById(String productId) throws ServiceException {
        this.getById(productId);
        cpuRepository.deleteById(productId);
    }

    
    
}
