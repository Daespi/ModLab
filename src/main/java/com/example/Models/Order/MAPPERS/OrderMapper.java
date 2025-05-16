package com.example.Models.Order.MAPPERS;

import com.example.Exceptions.BuildException;
import com.example.Models.Order.DTO.OrderDTO;
import com.example.Models.Order.Entity.Order;
import com.example.Models.Product.MAPPERS.ProductMapper;
import com.example.Models.Product.DTO.ProductDTO;
import com.example.Models.Product.Entity.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderMapper {

    public static Order orderFromDTO(OrderDTO dto) throws BuildException {
        Order order = Order.getInstance(dto.getStatus(), dto.getUserId(), dto.getPaymentId());

        order.setOrderDate(dto.getOrderDate());

        if (dto.getProducts() != null) {
            for (ProductDTO productDTO : dto.getProducts()) {
                Product product = ProductMapper.productFromDTO(productDTO);
                order.addProduct(product);
            }
        }

        return order;
    }

    public static OrderDTO dtoFromOrder(Order order) {
        List<ProductDTO> productDTOs = new ArrayList<>();
        for (Product product : order.getProducts()) {
            productDTOs.add(ProductMapper.dtoFromProduct(product));
        }

        return new OrderDTO(
                order.getOrderId(),
                order.getOrderDate(),
                order.getStatus(),
                order.getUserId(),
                order.getPaymentId(),
                productDTOs
        );
    }
}
