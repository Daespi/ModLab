
package com.example.Models.Product.Persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Models.Product.DTO.ProductDTO;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductDTO, String> {

    // Buscar producto por ID
    Optional<ProductDTO> findByProductId(String productId);

    // Buscar productos por nombre exacto
    List<ProductDTO> findByName(String name);

    // Buscar productos que contengan texto en el nombre
    List<ProductDTO> findByNameContaining(String partialName);

    // Contar productos que contengan texto en la descripción
    Integer countByDescriptionContaining(String text);

    // Buscar por marca
    List<ProductDTO> findByBrand(String brand);
}
