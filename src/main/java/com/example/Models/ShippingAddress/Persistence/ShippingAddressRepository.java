package com.example.Models.ShippingAddress.Persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

<<<<<<< HEAD
import com.example.Models.ShippingAddress.DTO.ShippingAddressDTO;

@Repository
public interface ShippingAddressRepository {

    Optional<ShippingAddressDTO> findById(int addressId);

    List<ShippingAddressDTO> findByAddress(String address);

    List<ShippingAddressDTO> findByAddressContaining(String partialAddress);

    Integer countByAddressContaining(String partialAddress);

    ShippingAddressDTO save(ShippingAddressDTO address);

    void deleteById(int addressId);
}
=======
import com.example.Models.User.DTO.UserDTO;


@Repository
public interface ShippingAddressRepository  {

    public Optional<UserDTO> findById(String isbn);

    public List<UserDTO> findByName(String title);
 
    public List<UserDTO> findByPartialTitle(String title);

    public Integer countByPartialTitle(String title);

    public UserDTO save(UserDTO book);
    
    public void deleteById(String isbn);
    
}

>>>>>>> dev_alex
