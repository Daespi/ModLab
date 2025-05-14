package com.example.infrastruture.persistence.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Models.OrderDetail.DTO.OrderDetailDTO;
import com.example.Models.OrderDetail.Persistence.OrderDetailRepository;

import jakarta.transaction.Transactional;

@Repository
public interface JpaOrderDetailRepository extends JpaRepository<OrderDetailDTO, String>, OrderDetailRepository {

    Optional<OrderDetailDTO> findByOrderDetailId(String orderDetailId);

    List<OrderDetailDTO> findByOrderId(String orderId);

    @Query("SELECT od FROM OrderDetailDTO od WHERE od.orderId LIKE %:orderId%")
    List<OrderDetailDTO> findByPartialOrderId(String orderId);

    @Query("SELECT COUNT(od) FROM OrderDetailDTO od WHERE od.orderId LIKE %:orderId%")
    Integer countByPartialOrderId(String orderId);

    @Transactional
    OrderDetailDTO save(OrderDetailDTO detail);

    @Transactional
    void deleteByOrderDetailId(String orderDetailId);

    @Transactional
    void deleteByOrderId(String orderId);
}
