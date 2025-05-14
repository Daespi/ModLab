package com.example.Models.OrderDetail.Appservices;

import com.example.Exceptions.ServiceException;
import org.springframework.stereotype.Service;

@Service
public interface OrderDetailServices {

    String getByIdToJson(String orderDetailId) throws ServiceException;

    String getByOrderIdToJson(String orderId) throws ServiceException;

    String addFromJson(String orderDetailJson) throws ServiceException;

    String updateOneFromJson(String orderDetailJson) throws ServiceException;

    void deleteById(String orderDetailId) throws ServiceException;

    void deleteAllByOrderId(String orderId) throws ServiceException;
}
