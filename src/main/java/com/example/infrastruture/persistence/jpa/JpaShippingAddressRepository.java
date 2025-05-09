<<<<<<< HEAD

package com.example.infrastruture.persistence.jpa;

import java.util.List;

=======
package com.example.infrastruture.persistence.jpa;

import java.util.List;
>>>>>>> 6724d2cce0b93a4f72da5a75b37fc63087426ee0

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Models.ShippingAddress.DTO.ShippingAddressDTO;
import com.example.Models.ShippingAddress.Persistence.ShippingAddressRepository;

@Repository
<<<<<<< HEAD
public interface JpaShippingAddressRepository extends JpaRepository<ShippingAddressDTO, Integer>, ShippingAddressRepository {
    // public Optional<ShippingAddressDTO> findByNif(String nif);
=======
public interface JpaShippingAddressRepository extends JpaRepository<ShippingAddressDTO, Integer>, ShippingAddressRepository
 {
>>>>>>> 6724d2cce0b93a4f72da5a75b37fc63087426ee0

    List<ShippingAddressDTO> findByAddress(String address);

    @Query("SELECT c FROM ShippingAddressDTO c WHERE c.address LIKE %:address%")
    List<ShippingAddressDTO> findByPartialAddress(String address);

    @Query("SELECT count(c) FROM ShippingAddressDTO c WHERE c.address LIKE %:address%")
    Integer countByPartialAddress(String address);
}
<<<<<<< HEAD
=======


>>>>>>> 6724d2cce0b93a4f72da5a75b37fc63087426ee0
