package com.example.Models.CPU.Appservices;

import com.example.Exceptions.ServiceException;

public interface CPUServices {

    String getByIdToJson(String productId) throws ServiceException;

    String addFromJson(String cpuJson) throws ServiceException;

    String updateOneFromJson(String productId, String cpuJson) throws ServiceException;

    void deleteById(String productId) throws ServiceException;
}
