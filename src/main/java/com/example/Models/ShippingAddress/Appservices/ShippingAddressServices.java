package com.example.Models.ShippingAddress.Appservices;

<<<<<<< HEAD
import com.example.Exceptions.ServiceException;

public interface ShippingAddressServices {
    String getByIdToJson(int addressId) throws ServiceException;
    String addFromJson(String address) throws ServiceException;
    String updateOneFromJson(String address) throws ServiceException;
    void deleteById(int addressId) throws ServiceException;
=======

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
>>>>>>> dev_alex
}
