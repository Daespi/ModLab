package com.example.Models.Order.MAPPERS;

import com.example.Exceptions.BuildException;
import com.example.Models.Order.DTO.OrderDTO;
import com.example.Models.Order.Entity.Order;
import com.example.Models.OrderDetail.DTO.OrderDetailDTO;
import com.example.Models.OrderDetail.Entity.OrderDetail;
import com.example.Models.OrderDetail.MAPPERS.OrderDetailMapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper {

    // De DTO a entidad: solo los datos del pedido, sin detalles (porque Order no tiene lista)
    public static Order orderFromDTO(OrderDTO dto) throws BuildException {
        // Crea el Order básico con los datos principales
        Order order = Order.getInstance(
            dto.getStatus(),
            dto.getUserId(),
            dto.getPaymentId(),
            dto.getAddressId(),
            dto.getTotalPrice()
        );

        order.setOrderDate(dto.getOrderDate());

        // Set totalPrice si existe en DTO
        if (dto.getTotalPrice() != null) {
            order.setTotalPrice(dto.getTotalPrice());
        }

        // No agregamos detalles aquí porque Order no tiene lista ni relación con detalles

        return order;
    }

    // De entidad a DTO: incluimos la lista de detalles en el DTO
    public static OrderDTO dtoFromOrder(Order order, List<OrderDetail> orderDetails) {
        List<OrderDetailDTO> detailDTOs = new ArrayList<>();

        if (orderDetails != null) {
            for (OrderDetail detail : orderDetails) {
                OrderDetailDTO detailDTO = OrderDetailMapper.dtoFromOrderDetail(detail);
                detailDTOs.add(detailDTO);
            }
        }

        return new OrderDTO(
            order.getOrderId(),
            order.getOrderDate(),
            order.getStatus(),
            order.getUserId(),
            order.getPaymentId(),
            order.getAddressId(),
            order.getTotalPrice(),  // <-- Aquí pasamos el totalPrice
            detailDTOs
        );
    }
}
