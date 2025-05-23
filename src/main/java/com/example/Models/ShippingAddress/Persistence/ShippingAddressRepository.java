package com.example.Models.ShippingAddress.Persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.Models.ShippingAddress.DTO.ShippingAddressDTO;
import com.example.Models.ShippingAddress.Entity.ShippingAddress;
import com.example.Models.ShopCart.DTO.ShopCartDTO;

@Repository
public interface ShippingAddressRepository {

    Optional<ShippingAddressDTO> findById(int addressId);

    List<ShippingAddressDTO> findByAddress(String address);

    List<ShippingAddressDTO> findByUserId(String userId);

    List<ShippingAddressDTO> findByAddressContaining(String partialAddress);

    Integer countByAddressContaining(String partialAddress);

    ShippingAddressDTO save(ShippingAddressDTO address);

    void deleteById(int addressId);
}