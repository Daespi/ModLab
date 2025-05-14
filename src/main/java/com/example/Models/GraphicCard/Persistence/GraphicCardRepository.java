package com.example.Models.GraphicCard.Persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Models.GraphicCard.DTO.GraphicCardDTO;

import java.util.List;
import java.util.Optional;

@Repository
public interface GraphicCardRepository extends JpaRepository<GraphicCardDTO, String> {

    Optional<GraphicCardDTO> findByProductId(String productId);

    List<GraphicCardDTO> findByName(String name);

    List<GraphicCardDTO> findByNameContaining(String partialName);

    Integer countByDescriptionContaining(String text);

    List<GraphicCardDTO> findByBrand(String brand);
}
