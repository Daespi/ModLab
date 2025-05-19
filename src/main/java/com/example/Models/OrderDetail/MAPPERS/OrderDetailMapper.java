package com.example.Models.OrderDetail.MAPPERS;

import com.example.Exceptions.BuildException;
import com.example.Models.OrderDetail.DTO.OrderDetailDTO;
import com.example.Models.OrderDetail.Entity.OrderDetail;

public class OrderDetailMapper {

    public static OrderDetail orderDetailFromDTO(OrderDetailDTO dto) throws BuildException {
        return OrderDetail.getInstance(
            dto.getOrderId(),
            dto.getProductId(),
            dto.getQuantity(),
            dto.getPrice()
        );
    }

    public static OrderDetailDTO dtoFromOrderDetail(OrderDetail entity) {
        return new OrderDetailDTO(
            entity.getOrderDetailId(),
            entity.getOrderId(),
            entity.getProductId(),
            entity.getQuantity(),
            entity.getPrice()
        );
    }
}
