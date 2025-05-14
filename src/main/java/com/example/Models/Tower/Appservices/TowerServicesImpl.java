// package com.example.Models.Tower.Appservices;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.Exceptions.BuildException;
// import com.example.Exceptions.ServiceException;
// import com.example.Models.Tower.DTO.TowerDTO;
// import com.example.Models.Tower.MAPPERS.TowerMapper;
// import com.example.Models.Tower.Persistence.TowerRepository;
// import com.example.sharedkernel.appservices.serializers.Serializer;
// import com.example.sharedkernel.appservices.serializers.Serializers;
// import com.example.sharedkernel.appservices.serializers.SerializersCatalog;

// @Service
// public class TowerServicesImpl implements TowerServices {

//     @Autowired
//     private TowerRepository towerRepository;

//     private final Serializer<TowerDTO> serializer = SerializersCatalog.getInstance(Serializers.Tower_JSON);

//     protected TowerDTO getDTO(String productId) {
//         return towerRepository.findById(productId).orElse(null);
//     }

//     protected TowerDTO getById(String productId) throws ServiceException {
//         TowerDTO dto = this.getDTO(productId);
//         if (dto == null) {
//             throw new ServiceException("Tower with ID " + productId + " not found.");
//         }
//         return dto;
//     }

//     protected TowerDTO checkInputData(String json) throws ServiceException {
//         try {
//             TowerDTO dto = this.serializer.deserialize(json, TowerDTO.class);
//             TowerMapper.towerFromDTO(dto); // Validación lógica
//             return dto;
//         } catch (BuildException e) {
//             throw new ServiceException("Error in Tower data: " + e.getMessage());
//         }
//     }

//     protected TowerDTO newTower(String json) throws ServiceException {
//         TowerDTO dto = this.checkInputData(json);
//         return towerRepository.save(dto);
//     }

//     protected TowerDTO updateTower(String productId, String json) throws ServiceException {
//         this.getById(productId); // Verificación
//         TowerDTO dto = this.checkInputData(json);
//         dto = new TowerDTO(
//             productId,
//             dto.getName(),
//             dto.getDescription(),
//             dto.getPrice(),
//             dto.getStockQuantity(),
//             dto.getRating(),
//             dto.getImageUrls(),
//             dto.getBrand(),
//             dto.getFormFactor(),
//             dto.getColor(),
//             dto.getConnectors(),
//             dto.getMaterial(),
//             dto.getFanSupport(),
//             dto.getMaxGpuLength(),
//             dto.getMaxCpuCoolerHeight(),
//             dto.getHigh(),
//             dto.getWidth(),
//             dto.getLength(),
//             dto.getWeight(),
//             dto.getFragile()
//         );
//         return towerRepository.save(dto);
//     }

//     @Override
//     public String getByIdToJson(String productId) throws ServiceException {
//         return serializer.serialize(this.getById(productId));
//     }

//     @Override
//     public String addFromJson(String towerJson) throws ServiceException {
//         return serializer.serialize(this.newTower(towerJson));
//     }

//     @Override
//     public String updateOneFromJson(String productId, String towerJson) throws ServiceException {
//         return serializer.serialize(this.updateTower(productId, towerJson));
//     }

//     @Override
//     public void deleteById(String productId) throws ServiceException {
//         this.getById(productId); // Verificación
//         towerRepository.deleteById(productId);
//     }
// }
