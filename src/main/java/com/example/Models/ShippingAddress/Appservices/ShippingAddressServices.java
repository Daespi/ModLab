package com.example.Models.ShippingAddress.Appservices;

import com.example.Exceptions.ServiceException;

public interface ShippingAddressServices {
    String getByIdToJson(int addressId) throws ServiceException;
    String addFromJson(String address) throws ServiceException;
    String updateOneFromJson(String address) throws ServiceException;
    void deleteById(int addressId) throws ServiceException;
    String updateOneFromJsonWithId(int addressId, String json) throws ServiceException;

}