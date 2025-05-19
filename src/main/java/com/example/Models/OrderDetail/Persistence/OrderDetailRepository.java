package com.example.Models.OrderDetail.Persistence;

import com.example.Models.OrderDetail.DTO.OrderDetailDTO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderDetailRepository {

    Optional<OrderDetailDTO> findByOrderDetailId(String orderDetailId);

    List<OrderDetailDTO> findByOrderId(String orderId);

    List<OrderDetailDTO> findByProductId(String productId);

    Integer countByOrderId(String orderId);

    OrderDetailDTO save(OrderDetailDTO detail);

    void deleteByOrderDetailId(String orderDetailId);

    void deleteByOrderId(String orderId);
}
