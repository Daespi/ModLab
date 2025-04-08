package com.example.infrastruture.persistence.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Models.User.DTO.UserDTO;
import com.example.Models.User.Persistence.UserRepository;

import jakarta.transaction.Transactional;

@Repository
public interface JpaUserRepository extends JpaRepository<UserDTO, String>, UserRepository {
<<<<<<< HEAD
    public Optional<UserDTO> findByEmail(String email);

    public List<UserDTO> findByusername(String username);
 
    @Query(value="SELECT b FROM UserDTO b WHERE b.username LIKE %:username%")
    public List<UserDTO> findByPartialUsername(String username);

    @Query(value="SELECT count(*) FROM UserDTO b WHERE b.username LIKE %:username%")
    public Integer countByPartialUsername(String username);

    @Transactional
    public UserDTO save(UserDTO user);
=======
    public Optional<UserDTO> findByIsbn(String isbn);

    public List<UserDTO> findByName(String name);
 
    @Query(value="SELECT b FROM UserDTO b WHERE b.name LIKE %:name%")
    public List<UserDTO> findByPartialTitle(String name);

    @Query(value="SELECT count(*) FROM UserDTO b WHERE b.name LIKE %:name%")
    public Integer countByPartialTitle(String name);

    @Transactional
    public UserDTO save(UserDTO book);
>>>>>>> dev_alex
    @Transactional
    public void deleteByIsbn(String isbn);
    
}
