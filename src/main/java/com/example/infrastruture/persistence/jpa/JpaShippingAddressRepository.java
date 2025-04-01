package com.example.infrastruture.persistence.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Models.ShippingAddress.DTO.ShippingAddressDTO;
import com.example.Models.ShippingAddress.Persistence.ShippingAddressRepository;

import jakarta.transaction.Transactional;

@Repository
public interface JpaShippingAddressRepository extends JpaRepository<ShippingAddressDTO, Integer>, ShippingAddressRepository {
    public Optional<ShippingAddressDTO> findByNif(String nif);

    public List<ShippingAddressDTO> findByName(String name);
 
    @Query(value="SELECT c FROM ShippingAddressDTO c WHERE c.name LIKE %:name%")
    public List<ShippingAddressDTO> findByPartialName(String name);

    @Query(value="SELECT count(*) FROM ShippingAddressDTO c WHERE c.name LIKE %:name%")
    public Integer countByPartialName(String name);

    @Transactional
    public ShippingAddressDTO save(ShippingAddressDTO client);
    @Transactional
    public void deleteByNif(String nif);
    
}
