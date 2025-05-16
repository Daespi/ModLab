package com.example.infrastruture.persistence.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Models.ShopCart.DTO.ShopCartDTO;
import com.example.Models.ShopCart.Persistence.ShopCartRepository;

import jakarta.transaction.Transactional;

@Repository
public interface JpaShopCartRepository extends JpaRepository<ShopCartDTO, Integer>, ShopCartRepository {

    Optional<ShopCartDTO> findByCartId(int cartId);

    List<ShopCartDTO> findByUserId(String userId);

    List<ShopCartDTO> findByUserIdAndProductId(String userId, String productId);

    @Query("SELECT count(sc) FROM ShopCartDTO sc WHERE sc.userId = :userId")
    Integer countByUserId(String userId);

    @Transactional
    ShopCartDTO save(ShopCartDTO cart);

    @Transactional
    void deleteByCartId(int cartId);

    @Transactional
    void deleteByUserId(String userId);
}
