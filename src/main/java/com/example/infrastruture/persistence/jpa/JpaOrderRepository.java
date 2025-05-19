package com.example.infrastruture.persistence.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Models.Order.DTO.OrderDTO;
import com.example.Models.Order.Persistence.OrderRepository;

import jakarta.transaction.Transactional;

@Repository
public interface JpaOrderRepository extends JpaRepository<OrderDTO, String>, OrderRepository {

    List<OrderDTO> findByUserId(String userId);

    List<OrderDTO> findByStatus(String status);

    @Query("SELECT o FROM OrderDTO o WHERE o.status LIKE %:status%")
    List<OrderDTO> findByPartialStatus(String status);

    @Query("SELECT count(o) FROM OrderDTO o WHERE o.status LIKE %:status%")
    Integer countByPartialStatus(String status);

    @Transactional
    OrderDTO save(OrderDTO order);

    @Transactional
    void deleteByUserId(String userId);
}
