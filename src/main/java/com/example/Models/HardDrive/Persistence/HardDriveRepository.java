// package com.example.Models.HardDrive.Persistence;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;
// import com.example.Models.HardDrive.DTO.HardDriveDTO;

// import java.util.List;
// import java.util.Optional;

// @Repository
// public interface HardDriveRepository extends JpaRepository<HardDriveDTO, String> {

//     Optional<HardDriveDTO> findByProductId(String productId);

//     List<HardDriveDTO> findByName(String name);

//     List<HardDriveDTO> findByNameContaining(String partialName);

//     Integer countByDescriptionContaining(String text);

//     List<HardDriveDTO> findByBrand(String brand);
// }
