// package com.example.infrastruture.persistence.jpa;

// import java.util.List;
// import java.util.Optional;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;
// import jakarta.transaction.Transactional;

// import com.example.Models.PowerSupply.DTO.PowerSupplyDTO;

// @Repository
// public interface JpaPowerSupplyRepository extends JpaRepository<PowerSupplyDTO, String> {

//     Optional<PowerSupplyDTO> findByProductId(String productId);

//     List<PowerSupplyDTO> findByBrand(String brand);

//     List<PowerSupplyDTO> findByNameContaining(String partialName);

//     @Transactional
//     PowerSupplyDTO save(PowerSupplyDTO powerSupply);

//     @Transactional
//     void deleteByProductId(String productId);
// }
