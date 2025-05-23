package com.example.Models.PaymentMethod.Appservices;

import com.example.Exceptions.ServiceException;
import org.springframework.stereotype.Service;

@Service
public interface PaymentMethodServices {

    String getByIdToJson(String paymentId) throws ServiceException;

    String addFromJson(String paymentMethodJson) throws ServiceException;

    String getPaymentMethodsByUserIdToJson(String userId) throws ServiceException;

    String updateOneFromJson(String paymentId, String paymentMethodJson) throws ServiceException;

    void deleteById(String paymentId) throws ServiceException;
}