package com.example.Models.ShopCart.MAPPER;

import com.example.Exceptions.BuildException;
import com.example.Models.ShopCart.DTO.ShopCartDTO;
import com.example.Models.ShopCart.Entity.ShopCart;

public class ShopCartMapper {

    public static ShopCart shopCartFromDTO(ShopCartDTO dto) throws BuildException {
        // Solo usaremos los campos necesarios para crear el objeto
        return ShopCart.getInstance(
            dto.getUserId(),
            dto.getProductId(),
            dto.getQuantity()
        );
        // El cartId y dateAdded serán generados automáticamente
    }

    public static ShopCartDTO dtoFromShopCart(ShopCart cart) {
        return new ShopCartDTO(
            cart.getCartId(),           // ahora es int
            cart.getUserId(),
            cart.getProductId(),
            cart.getQuantity()
        );
    }
}
