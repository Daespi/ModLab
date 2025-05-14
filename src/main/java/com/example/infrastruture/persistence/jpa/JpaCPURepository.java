package com.example.infrastruture.persistence.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import jakarta.transaction.Transactional;

import com.example.Models.CPU.DTO.CPUDTO;

@Repository
public interface JpaCPURepository extends JpaRepository<CPUDTO, String> {

    Optional<CPUDTO> findByProductId(String productId);

    List<CPUDTO> findByBrand(String brand);

    List<CPUDTO> findByNameContaining(String partialName);

    @Transactional
    CPUDTO save(CPUDTO cpu);

    @Transactional
    void deleteByProductId(String productId);
}
