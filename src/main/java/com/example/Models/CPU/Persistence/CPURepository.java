package com.example.Models.CPU.Persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Models.CPU.DTO.CPUDTO;

import java.util.List;
import java.util.Optional;

@Repository
public interface CPURepository extends JpaRepository<CPUDTO, String> {

    Optional<CPUDTO> findByProductId(String productId);

    List<CPUDTO> findByName(String name);

    List<CPUDTO> findByNameContaining(String partialName);

    Integer countByDescriptionContaining(String text);

    List<CPUDTO> findByBrand(String brand);
}
