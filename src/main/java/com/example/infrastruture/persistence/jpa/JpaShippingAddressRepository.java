
package com.example.infrastruture.persistence.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Models.ShippingAddress.DTO.ShippingAddressDTO;
import com.example.Models.ShippingAddress.Persistence.ShippingAddressRepository;

@Repository

public interface JpaShippingAddressRepository extends JpaRepository<ShippingAddressDTO, Integer>, ShippingAddressRepository
 {

    List<ShippingAddressDTO> findByAddress(String address);

    @Query("SELECT c FROM ShippingAddressDTO c WHERE c.address LIKE %:address%")
    List<ShippingAddressDTO> findByPartialAddress(String address);

    @Query("SELECT count(c) FROM ShippingAddressDTO c WHERE c.address LIKE %:address%")
    Integer countByPartialAddress(String address);
}
