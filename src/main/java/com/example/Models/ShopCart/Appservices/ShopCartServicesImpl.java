package com.example.Models.ShopCart.Appservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.Exceptions.BuildException;
import com.example.Exceptions.ServiceException;
import com.example.Models.ShopCart.DTO.ShopCartDTO;
import com.example.Models.ShopCart.Entity.ShopCart;
import com.example.Models.ShopCart.MAPPER.ShopCartMapper;
import com.example.Models.ShopCart.Persistence.ShopCartRepository;
import com.example.sharedkernel.appservices.serializers.Serializer;
import com.example.sharedkernel.appservices.serializers.Serializers;
import com.example.sharedkernel.appservices.serializers.SerializersCatalog;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class ShopCartServicesImpl implements ShopCartServices {

    @Autowired
    private ShopCartRepository shopCartRepository;

    private Serializer<ShopCartDTO> serializer;

    protected ShopCartDTO getDTO(int cartId) {
        return shopCartRepository.findByCartId(cartId).orElse(null);
    }

    protected ShopCartDTO getById(int cartId) throws ServiceException {
        ShopCartDTO dto = this.getDTO(cartId);
        if (dto == null) {
            throw new ServiceException("Cart ID " + cartId + " not found");
        }
        return dto;
    }

    protected ShopCartDTO checkInputData(String json) throws ServiceException {
        try {
            ShopCartDTO dto = this.serializer.deserialize(json, ShopCartDTO.class);
            ShopCartMapper.shopCartFromDTO(dto); // Validación de negocio
            return dto;
        } catch (BuildException e) {
            throw new ServiceException("Error in cart input: " + e.getMessage());
        }
    }

    protected ShopCartDTO newCart(String json) throws ServiceException {
        ShopCartDTO dto = this.checkInputData(json);

        // dateAdded solo si no viene en el JSON
        if (dto.getDateAdded() == null) {
            dto = new ShopCartDTO(
                0, dto.getUserId(), dto.getProductId(), dto.getQuantity(), LocalDateTime.now()
            );
        }

        return shopCartRepository.save(dto);
    }

    protected ShopCartDTO updateCartQuantity(String json) throws ServiceException {
        ShopCartDTO dto = this.checkInputData(json);
        this.getById(dto.getCartId()); // Verifica existencia
        return shopCartRepository.save(dto); // Actualiza
    }

    @Override
    public String getCartByUserIdToJson(String userId) throws ServiceException {
        return SerializersCatalog.getInstance(Serializers.SHOPCART_JSON)
                .serialize(shopCartRepository.findByUserId(userId));
    }

    @Override
    public String addFromJson(String cartJson) throws ServiceException {
        this.serializer = SerializersCatalog.getInstance(Serializers.SHOPCART_JSON);
        return serializer.serialize(this.newCart(cartJson));
    }

    @Override
    public String updateQuantityFromJson(String cartJson) throws ServiceException {
        this.serializer = SerializersCatalog.getInstance(Serializers.SHOPCART_JSON);
        return serializer.serialize(this.updateCartQuantity(cartJson));
    }

    @Override
    public void deleteByCartId(int cartId) throws ServiceException {
        this.getById(cartId);
        shopCartRepository.deleteByCartId(cartId);
    }

    @Override
    public void clearCartByUserId(String userId) throws ServiceException {
        List<ShopCartDTO> list = shopCartRepository.findByUserId(userId);
        if (list == null || list.isEmpty()) {
            throw new ServiceException("No cart entries found for user " + userId);
        }
        shopCartRepository.deleteByUserId(userId);
    }
}
