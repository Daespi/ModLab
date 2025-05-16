// package com.example.infrastruture.persistence.jpa;

// import java.util.List;
// import java.util.Optional;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;
// import jakarta.transaction.Transactional;

// import com.example.Models.HardDrive.DTO.HardDriveDTO;

// @Repository
// public interface JpaHardDriveRepository extends JpaRepository<HardDriveDTO, String> {

//     Optional<HardDriveDTO> findByProductId(String productId);

//     List<HardDriveDTO> findByBrand(String brand);

//     List<HardDriveDTO> findByNameContaining(String partialName);

//     @Transactional
//     HardDriveDTO save(HardDriveDTO hardDrive);

//     @Transactional
//     void deleteByProductId(String productId);
// }
