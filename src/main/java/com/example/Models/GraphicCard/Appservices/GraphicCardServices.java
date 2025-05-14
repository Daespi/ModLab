package com.example.Models.GraphicCard.Appservices;

import com.example.Exceptions.ServiceException;

public interface GraphicCardServices {

    String getByIdToJson(String productId) throws ServiceException;

    String addFromJson(String graphicCardJson) throws ServiceException;

    String updateOneFromJson(String productId, String graphicCardJson) throws ServiceException;

    void deleteById(String productId) throws ServiceException;
}
