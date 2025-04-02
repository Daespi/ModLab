package com.example.Models.User.Persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.Models.User.DTO.UserDTO;


@Repository
public interface UserRepository  {

    public Optional<UserDTO> findById(String isbn);

    public List<UserDTO> findByName(String title);
 
    public List<UserDTO> findByPartialTitle(String title);

    public Integer countByPartialTitle(String title);

    public UserDTO save(UserDTO book);
    
    public void deleteById(String isbn);
    
}

