package com.example.Models.ShopCart.Persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.Models.ShopCart.DTO.ShopCartDTO;

@Repository
public interface ShopCartRepository {

    Optional<ShopCartDTO> findByCartId(int cartId);

    List<ShopCartDTO> findByUserId(String userId);

    List<ShopCartDTO> findByUserIdAndProductId(String userId, String productId);

    Integer countByUserId(String userId);

    ShopCartDTO save(ShopCartDTO cart);

    void deleteByCartId(int cartId);

    void deleteByUserId(String userId);
}
