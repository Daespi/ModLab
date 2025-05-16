package com.example.Models.Order.Appservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Exceptions.BuildException;
import com.example.Exceptions.ServiceException;
import com.example.Models.Order.DTO.OrderDTO;
import com.example.Models.Order.MAPPERS.OrderMapper;
import com.example.Models.Order.Persistence.OrderRepository;
import com.example.sharedkernel.appservices.serializers.Serializer;
import com.example.sharedkernel.appservices.serializers.Serializers;
import com.example.sharedkernel.appservices.serializers.SerializersCatalog;

import java.util.UUID;

@Service
public class OrderServicesImpl implements OrderServices {

    @Autowired
    private OrderRepository orderRepository;

    private final Serializer<OrderDTO> serializer = SerializersCatalog.getInstance(Serializers.ORDER_JSON);

    protected OrderDTO getDTO(String orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    protected OrderDTO getById(String orderId) throws ServiceException {
        OrderDTO dto = this.getDTO(orderId);
        if (dto == null) {
            throw new ServiceException("Order with ID " + orderId + " not found.");
        }
        return dto;
    }

    protected OrderDTO checkInputData(String json) throws ServiceException {
        try {
            OrderDTO dto = this.serializer.deserialize(json, OrderDTO.class);
            OrderMapper.orderFromDTO(dto); // Validación lógica
            return dto;
        } catch (BuildException e) {
            throw new ServiceException("Error in Order data: " + e.getMessage());
        }
    }

    protected OrderDTO newOrder(String json) throws ServiceException {
        OrderDTO dto = this.checkInputData(json);

        if (dto.getOrderId() == null || dto.getOrderId().isBlank()) {
            dto.setOrderId(UUID.randomUUID().toString().replace("-", "").substring(0, 32));
        }

        if (this.getDTO(dto.getOrderId()) == null) {
            return orderRepository.save(dto);
        }

        throw new ServiceException("Order with ID " + dto.getOrderId() + " already exists.");
    }

    protected OrderDTO updateOrder(String json) throws ServiceException {
        OrderDTO dto = this.checkInputData(json);
        this.getById(dto.getOrderId());
        return orderRepository.save(dto);
    }

    @Override
    public String getByIdToJson(String orderId) throws ServiceException {
        return serializer.serialize(this.getById(orderId));
    }

    @Override
    public String addFromJson(String orderJson) throws ServiceException {
        return serializer.serialize(this.newOrder(orderJson));
    }

    @Override
    public String updateOneFromJson(String orderJson) throws ServiceException {
        return serializer.serialize(this.updateOrder(orderJson));
    }

    @Override
    public void deleteById(String orderId) throws ServiceException {
        this.getById(orderId);
        orderRepository.deleteById(orderId);
    }
}
