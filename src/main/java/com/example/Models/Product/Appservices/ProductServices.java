package com.example.Models.Product.Appservices;

import com.example.Exceptions.ServiceException;

public interface ProductServices {

    String getByIdToJson(String productId) throws ServiceException;

    String addFromJson(String productJson) throws ServiceException;

    String updateOneFromJson(String productId, String productJson) throws ServiceException;

    void deleteById(String productId) throws ServiceException;
}
