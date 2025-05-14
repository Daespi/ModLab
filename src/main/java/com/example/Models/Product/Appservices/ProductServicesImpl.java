package com.example.Models.Product.Appservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Exceptions.BuildException;
import com.example.Exceptions.ServiceException;
import com.example.Models.Product.DTO.ProductDTO;
import com.example.Models.Product.Entity.Product;
import com.example.Models.Product.MAPPERS.ProductMapper;
import com.example.Models.Product.Persistence.ProductRepository;
import com.example.sharedkernel.appservices.serializers.Serializer;
import com.example.sharedkernel.appservices.serializers.Serializers;
import com.example.sharedkernel.appservices.serializers.SerializersCatalog;

@Service
public class ProductServicesImpl implements ProductServices {

    @Autowired
    private ProductRepository productRepository;

    private final Serializer<ProductDTO> serializer = SerializersCatalog.getInstance(Serializers.PRODUCT_JSON);

    protected ProductDTO getDTO(String productId) {
        return productRepository.findById(productId).orElse(null);
    }

    protected ProductDTO getById(String productId) throws ServiceException {
        ProductDTO dto = this.getDTO(productId);
        if (dto == null) {
            throw new ServiceException("Producto con ID " + productId + " no encontrado.");
        }
        return dto;
    }

    protected ProductDTO checkInputData(String json) throws ServiceException {
        try {
            ProductDTO dto = this.serializer.deserialize(json, ProductDTO.class);
            Product producto = ProductMapper.productFromDTO(dto);  // Validación de lógica
            return ProductMapper.dtoFromProduct(producto);         // Devuelve instancia concreta como CPUDTO o RamDTO
        } catch (BuildException e) {
            throw new ServiceException("Error en los datos del producto: " + e.getMessage());
        } catch (UnsupportedOperationException e) {
            throw new ServiceException("Subclase de producto no soportada para este servicio.");
        }
    }

    protected ProductDTO newProduct(String json) throws ServiceException {
        ProductDTO dto = this.checkInputData(json);
        return productRepository.save(dto);
    }

    protected ProductDTO updateProduct(String productId, String json) throws ServiceException {
        this.getById(productId); // Verificación de existencia
        ProductDTO dto = this.checkInputData(json);
        return productRepository.save(dto);
    }

    @Override
    public String getByIdToJson(String productId) throws ServiceException {
        return serializer.serialize(this.getById(productId));
    }

    @Override
    public String addFromJson(String productJson) throws ServiceException {
        return serializer.serialize(this.newProduct(productJson));
    }

    @Override
    public String updateOneFromJson(String productId, String productJson) throws ServiceException {
        return serializer.serialize(this.updateProduct(productId, productJson));
    }

    @Override
    public void deleteById(String productId) throws ServiceException {
        this.getById(productId);
        productRepository.deleteById(productId);
    }
}
