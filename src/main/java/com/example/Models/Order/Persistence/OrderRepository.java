package com.example.Models.Order.Persistence;

import com.example.Models.Order.DTO.OrderDTO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository {

    Optional<OrderDTO> findById(String orderId);

    List<OrderDTO> findByUserId(String userId);

    List<OrderDTO> findByStatusContaining(String status);

    Integer countByStatusContaining(String status);

    OrderDTO save(OrderDTO order);

    void deleteById(String orderId);
}