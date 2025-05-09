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

=======
>>>>>>> 6724d2cce0b93a4f72da5a75b37fc63087426ee0
    public Optional<UserDTO> findByEmail(String email);

    public List<UserDTO> findByusername(String username);
 
    @Query(value="SELECT b FROM UserDTO b WHERE b.username LIKE %:username%")
    public List<UserDTO> findByPartialUsername(String username);

    @Query(value="SELECT count(*) FROM UserDTO b WHERE b.username LIKE %:username%")
    public Integer countByPartialUsername(String username);

    @Transactional
    public UserDTO save(UserDTO user);

    @Transactional
<<<<<<< HEAD
    public void deleteByIsbn(String isbn);
=======
    public void deleteByUsername(String username);
>>>>>>> 6724d2cce0b93a4f72da5a75b37fc63087426ee0
    
}
