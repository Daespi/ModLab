
package com.example.Models.Product.MAPPERS;

import com.example.Exceptions.BuildException;
import com.example.Models.CPU.DTO.CPUDTO;
import com.example.Models.CPU.Entity.CPU;
import com.example.Models.CPU.MAPPERS.CPUMapper;
import com.example.Models.Product.DTO.ProductDTO;
import com.example.Models.Product.Entity.Product;

public abstract class ProductMapper {

    public static Product productFromDTO(ProductDTO dto) throws BuildException {
        if (dto instanceof CPUDTO) {
            return CPUMapper.cpuFromDTO((CPUDTO) dto);
        }
        throw new UnsupportedOperationException(
            "Conversión desde DTO no soportada para este tipo: " + dto.getClass().getSimpleName()
        );
    }

    public static ProductDTO dtoFromProduct(Product product) {
        if (product instanceof CPU) {
            return CPUMapper.dtoFromCPU((CPU) product);
        }
        throw new UnsupportedOperationException(
            "Conversión desde entidad no soportada para este tipo: " + product.getClass().getSimpleName()
        );
    }
}
