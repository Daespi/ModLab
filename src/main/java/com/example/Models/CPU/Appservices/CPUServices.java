package com.example.Models.CPU.Appservices;

import com.example.Exceptions.ServiceException;

public interface CPUServices {

    String getByIdToJson(String productId) throws ServiceException;

    String addFromJson(String productJson) throws ServiceException;

    String updateOneFromJson(String productId, String productJson) throws ServiceException;

    void deleteById(String productId) throws ServiceException;
}
