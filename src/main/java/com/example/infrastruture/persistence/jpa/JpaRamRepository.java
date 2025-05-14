package com.example.infrastruture.persistence.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import jakarta.transaction.Transactional;

import com.example.Models.Ram.DTO.RamDTO;

@Repository
public interface JpaRamRepository extends JpaRepository<RamDTO, String> {

    Optional<RamDTO> findByProductId(String productId);

    List<RamDTO> findByBrand(String brand);

    List<RamDTO> findByNameContaining(String partialName);

    @Transactional
    RamDTO save(RamDTO ram);

    @Transactional
    void deleteByProductId(String productId);
}
