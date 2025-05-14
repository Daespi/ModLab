package com.example.infrastruture.persistence.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Models.Ventilation.DTO.VentilationDTO;

import jakarta.transaction.Transactional;

@Repository
public interface JpaVentilationRepository extends JpaRepository<VentilationDTO, String> {

    Optional<VentilationDTO> findByProductId(String productId);

    List<VentilationDTO> findByBrand(String brand);

    List<VentilationDTO> findByNameContaining(String partialName);

    @Transactional
    VentilationDTO save(VentilationDTO ventilation);

    @Transactional
    void deleteByProductId(String productId);
}
