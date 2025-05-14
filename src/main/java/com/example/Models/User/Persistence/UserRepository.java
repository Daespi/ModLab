package com.example.Models.User.Persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Models.User.DTO.UserDTO;

@Repository
public interface UserRepository {

    Optional<UserDTO> findById(String userId);

    @Query("SELECT u FROM UserDTO u WHERE u.email = :email")
    UserDTO findUserByEmail(@Param("email") String email);


    List<UserDTO> findByUsername(String username);

    List<UserDTO> findByUsernameContaining(String Username);

    Integer countByUsernameContaining(String Username);

    UserDTO save(UserDTO user);

    void deleteById(String userId);
}