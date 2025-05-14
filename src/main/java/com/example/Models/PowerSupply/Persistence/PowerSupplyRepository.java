package com.example.Models.PowerSupply.Persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Models.PowerSupply.DTO.PowerSupplyDTO;

import java.util.List;
import java.util.Optional;

@Repository
public interface PowerSupplyRepository extends JpaRepository<PowerSupplyDTO, String> {

    Optional<PowerSupplyDTO> findByProductId(String productId);

    List<PowerSupplyDTO> findByName(String name);

    List<PowerSupplyDTO> findByNameContaining(String partialName);

    Integer countByDescriptionContaining(String text);

    List<PowerSupplyDTO> findByBrand(String brand);
}
