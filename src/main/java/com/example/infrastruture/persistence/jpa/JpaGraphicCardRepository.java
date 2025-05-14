package com.example.infrastruture.persistence.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import jakarta.transaction.Transactional;

import com.example.Models.GraphicCard.DTO.GraphicCardDTO;

@Repository
public interface JpaGraphicCardRepository extends JpaRepository<GraphicCardDTO, String> {

    Optional<GraphicCardDTO> findByProductId(String productId);

    List<GraphicCardDTO> findByBrand(String brand);

    List<GraphicCardDTO> findByNameContaining(String partialName);

    @Transactional
    GraphicCardDTO save(GraphicCardDTO graphicCard);

    @Transactional
    void deleteByProductId(String productId);
}
