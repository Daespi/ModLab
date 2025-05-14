package com.example.Models.Ventilation.Persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Models.Ventilation.DTO.VentilationDTO;

import java.util.List;
import java.util.Optional;

@Repository
public interface VentilationRepository extends JpaRepository<VentilationDTO, String> {

    Optional<VentilationDTO> findByProductId(String productId);

    List<VentilationDTO> findByBrand(String brand);

    List<VentilationDTO> findByNameContaining(String partialName);

    Integer countByDescriptionContaining(String text);
}
