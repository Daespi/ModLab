package com.example.Models.Ventilation.Appservices;

import com.example.Exceptions.ServiceException;

public interface VentilationServices {

    String getByIdToJson(String productId) throws ServiceException;

    String addFromJson(String ventilationJson) throws ServiceException;

    String updateOneFromJson(String productId, String ventilationJson) throws ServiceException;

    void deleteById(String productId) throws ServiceException;
}
