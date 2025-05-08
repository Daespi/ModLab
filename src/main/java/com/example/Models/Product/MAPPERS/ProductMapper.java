package com.example.Models.Product.MAPPERS;

import com.example.Exceptions.BuildException;
import com.example.Models.Product.DTO.ProductDTO;
import com.example.Models.Product.Entity.Product;

public abstract class ProductMapper {

    // Método para convertir de DTO a entidad — deberá ser implementado por cada subclase
    public static Product productFromDTO(ProductDTO dto) throws BuildException {
        throw new UnsupportedOperationException("Este método debe ser implementado en subclases específicas.");
    }

    // Método para convertir de entidad a DTO — deberá ser implementado por cada subclase
    public static ProductDTO dtoFromProduct(Product product) {
        throw new UnsupportedOperationException("Este método debe ser implementado en subclases específicas.");
    }
}
