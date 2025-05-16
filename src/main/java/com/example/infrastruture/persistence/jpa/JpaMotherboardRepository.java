// package com.example.infrastruture.persistence.jpa;

// import java.util.List;
// import java.util.Optional;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;
// import jakarta.transaction.Transactional;

// import com.example.Models.Motherboard.DTO.MotherBoardDTO;

// @Repository
// public interface JpaMotherboardRepository extends JpaRepository<MotherBoardDTO, String> {

//     Optional<MotherBoardDTO> findByProductId(String productId);

//     List<MotherBoardDTO> findByBrand(String brand);

//     List<MotherBoardDTO> findByNameContaining(String partialName);

//     @Transactional
//     MotherBoardDTO save(MotherBoardDTO motherboard);

//     @Transactional
//     void deleteByProductId(String productId);
// }
