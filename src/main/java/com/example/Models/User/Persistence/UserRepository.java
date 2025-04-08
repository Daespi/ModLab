package com.example.Models.User.Persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.Models.User.DTO.UserDTO;


@Repository
public interface UserRepository  {

    public Optional<UserDTO> findById(String id);

    public List<UserDTO> findByName(String username);
 
    public List<UserDTO> findByPartialTitle(String username);

    public Integer countByPartialTitle(String username);

    public UserDTO save(UserDTO client);
    
    public void deleteById(String id);
    
}

