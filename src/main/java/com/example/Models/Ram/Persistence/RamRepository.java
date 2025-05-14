// package com.example.Models.Ram.Persistence;

// import com.example.Models.Ram.DTO.RamDTO;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// import java.util.List;
// import java.util.Optional;

// @Repository
// public interface RamRepository extends JpaRepository<RamDTO, String> {

//     Optional<RamDTO> findByProductId(String productId);

//     List<RamDTO> findByName(String name);

//     List<RamDTO> findByNameContaining(String partialName);

//     Integer countByDescriptionContaining(String text);

//     List<RamDTO> findByBrand(String brand);
// }
