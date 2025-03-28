package com.example.Models.ShippingAddress.Appservices;


import org.springframework.stereotype.Service;

import com.example.Exceptions.ServiceException;

@Service
public interface ShippingAddressServices {
    public String getByIdToJson (String isbn) throws ServiceException;
    public String getByIdToXml (String isbn) throws ServiceException;
    public String addFromJson (String book) throws ServiceException;
    public String addFromXml (String book) throws ServiceException;
    public String updateOneFromJson(String book) throws ServiceException;
    public String updateOneFromXml(String book) throws ServiceException;
    public void deleteById(String isbn) throws ServiceException;
}
