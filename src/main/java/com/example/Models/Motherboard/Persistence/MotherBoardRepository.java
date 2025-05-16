package com.example.Models.Motherboard.Persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Models.Motherboard.DTO.MotherBoardDTO;

import java.util.List;
import java.util.Optional;

@Repository
public interface MotherBoardRepository extends JpaRepository<MotherBoardDTO, String> {

    Optional<MotherBoardDTO> findByProductId(String productId);

    List<MotherBoardDTO> findByName(String name);

    List<MotherBoardDTO> findByNameContaining(String partialName);

    Integer countByDescriptionContaining(String text);

    List<MotherBoardDTO> findByBrand(String brand);
}
