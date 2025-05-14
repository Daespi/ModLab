package com.example.infrastruture.persistence.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Models.Tower.DTO.TowerDTO;

import jakarta.transaction.Transactional;

@Repository
public interface JpaTowerRepository extends JpaRepository<TowerDTO, String> {

    Optional<TowerDTO> findByProductId(String productId);

    List<TowerDTO> findByBrand(String brand);

    List<TowerDTO> findByNameContaining(String partialName);

    @Transactional
    TowerDTO save(TowerDTO tower);

    @Transactional
    void deleteByProductId(String productId);
}
