package com.example.infrastruture.persistence.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Models.User.DTO.UserDTO;
import com.example.softlearning.applicationcore.entity.book.persistence.UserRepository;

import jakarta.transaction.Transactional;

@Repository
public interface JpaUserRepository extends JpaRepository<UserDTO, String>, UserRepository {
    public Optional<UserDTO> findByIsbn(String isbn);

    public List<UserDTO> findByName(String name);
 
    @Query(value="SELECT b FROM UserDTO b WHERE b.name LIKE %:name%")
    public List<UserDTO> findByPartialTitle(String name);

    @Query(value="SELECT count(*) FROM UserDTO b WHERE b.name LIKE %:name%")
    public Integer countByPartialTitle(String name);

    @Transactional
    public UserDTO save(UserDTO book);
    @Transactional
    public void deleteByIsbn(String isbn);
    
}
