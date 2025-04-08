package com.example.Models.User.Persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.Models.User.DTO.UserDTO;

<<<<<<< HEAD
@Repository
public interface UserRepository {

    Optional<UserDTO> findById(String userId);

    List<UserDTO> findByUsername(String username);

    List<UserDTO> findByUsernameContaining(String Username);

    Integer countByUsernameContaining(String Username);

    UserDTO save(UserDTO user);

    void deleteById(String userId);
}
=======

@Repository
public interface UserRepository  {

    public Optional<UserDTO> findById(String isbn);

    public List<UserDTO> findByName(String title);
 
    public List<UserDTO> findByPartialTitle(String title);

    public Integer countByPartialTitle(String title);

    public UserDTO save(UserDTO book);
    
    public void deleteById(String isbn);
    
}

>>>>>>> dev_alex
