package com.example.Models.Order.Appservices;

import com.example.Exceptions.ServiceException;
import org.springframework.stereotype.Service;

@Service
public interface OrderServices {

    String getByIdToJson(String orderId) throws ServiceException;

    String addFromJson(String orderJson) throws ServiceException;

    String updateOneFromJson(String orderJson) throws ServiceException;

    void deleteById(String orderId) throws ServiceException;
}
