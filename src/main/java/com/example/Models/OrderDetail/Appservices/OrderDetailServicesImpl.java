package com.example.Models.OrderDetail.Appservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Exceptions.BuildException;
import com.example.Exceptions.ServiceException;
import com.example.Models.OrderDetail.DTO.OrderDetailDTO;
import com.example.Models.OrderDetail.MAPPERS.OrderDetailMapper;
import com.example.Models.OrderDetail.Persistence.OrderDetailRepository;
import com.example.sharedkernel.appservices.serializers.Serializer;
import com.example.sharedkernel.appservices.serializers.Serializers;
import com.example.sharedkernel.appservices.serializers.SerializersCatalog;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.UUID;

@Service
public class OrderDetailServicesImpl implements OrderDetailServices {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    private final Serializer<OrderDetailDTO> serializer =
            SerializersCatalog.getInstance(Serializers.ORDER_DETAIL_JSON);

    private final ObjectMapper objectMapper = new ObjectMapper();

    protected OrderDetailDTO getDTO(String orderDetailId) {
        return orderDetailRepository.findByOrderDetailId(orderDetailId).orElse(null);
    }

    protected OrderDetailDTO getById(String orderDetailId) throws ServiceException {
        OrderDetailDTO dto = this.getDTO(orderDetailId);
        if (dto == null) {
            throw new ServiceException("OrderDetail with ID " + orderDetailId + " not found.");
        }
        return dto;
    }

    protected OrderDetailDTO checkInputData(String json) throws ServiceException {
        try {
            OrderDetailDTO dto = this.serializer.deserialize(json, OrderDetailDTO.class);
            OrderDetailMapper.orderDetailFromDTO(dto); // Validación de negocio
            return dto;
        } catch (BuildException e) {
            throw new ServiceException("Invalid OrderDetail data: " + e.getMessage());
        }
    }

    protected OrderDetailDTO newDetail(String json) throws ServiceException {
        OrderDetailDTO dto = this.checkInputData(json);

        if (dto.getOrderDetailId() == null || dto.getOrderDetailId().isBlank()) {
            dto = new OrderDetailDTO(
                    UUID.randomUUID().toString().replace("-", "").substring(0, 32),
                    dto.getOrderId(),
                    dto.getProductId(),
                    dto.getQuantity(),
                    dto.getPrice()
            );
        }

        if (this.getDTO(dto.getOrderDetailId()) == null) {
            return orderDetailRepository.save(dto);
        }

        throw new ServiceException("OrderDetail with ID " + dto.getOrderDetailId() + " already exists.");
    }

    protected OrderDetailDTO updateDetail(String json) throws ServiceException {
        OrderDetailDTO dto = this.checkInputData(json);
        this.getById(dto.getOrderDetailId());
        return orderDetailRepository.save(dto);
    }

    @Override
    public String getByIdToJson(String orderDetailId) throws ServiceException {
        return serializer.serialize(this.getById(orderDetailId));
    }

    @Override
    public String getByOrderIdToJson(String orderId) throws ServiceException {
        List<OrderDetailDTO> list = orderDetailRepository.findByOrderId(orderId);
        if (list == null || list.isEmpty()) {
            throw new ServiceException("No details found for Order " + orderId);
        }

        try {
            return objectMapper.writeValueAsString(list);
        } catch (JsonProcessingException e) {
            throw new ServiceException("Error serializing order details list: " + e.getMessage());
        }
    }

    @Override
    public String addFromJson(String orderDetailJson) throws ServiceException {
        return serializer.serialize(this.newDetail(orderDetailJson));
    }

    @Override
    public String updateOneFromJson(String orderDetailJson) throws ServiceException {
        return serializer.serialize(this.updateDetail(orderDetailJson));
    }

    @Override
    public void deleteById(String orderDetailId) throws ServiceException {
        this.getById(orderDetailId);
        orderDetailRepository.deleteByOrderDetailId(orderDetailId);
    }

    @Override
    public void deleteAllByOrderId(String orderId) throws ServiceException {
        List<OrderDetailDTO> details = orderDetailRepository.findByOrderId(orderId);
        if (details == null || details.isEmpty()) {
            throw new ServiceException("No details found for Order " + orderId);
        }
        orderDetailRepository.deleteByOrderId(orderId);
    }
}
