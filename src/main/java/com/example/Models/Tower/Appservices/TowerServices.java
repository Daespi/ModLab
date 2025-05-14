package com.example.Models.Tower.Appservices;

import com.example.Exceptions.ServiceException;

public interface TowerServices {

    String getByIdToJson(String productId) throws ServiceException;

    String addFromJson(String towerJson) throws ServiceException;

    String updateOneFromJson(String productId, String towerJson) throws ServiceException;

    void deleteById(String productId) throws ServiceException;
}
