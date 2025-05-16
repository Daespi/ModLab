// package com.example.Models.Tower.Persistence;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// import com.example.Models.Tower.DTO.TowerDTO;

// import java.util.List;
// import java.util.Optional;

// @Repository
// public interface TowerRepository extends JpaRepository<TowerDTO, String> {

//     Optional<TowerDTO> findByProductId(String productId);

//     List<TowerDTO> findByBrand(String brand);

//     List<TowerDTO> findByNameContaining(String partialName);

//     Integer countByDescriptionContaining(String text);
// }
