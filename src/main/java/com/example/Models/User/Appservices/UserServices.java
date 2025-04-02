package com.example.Models.User.Appservices;

import org.springframework.stereotype.Service;

import com.example.Exceptions.ServiceException;

@Service
public interface UserServices {
    public String getByIdToJson (String isbn) throws ServiceException;
    public String addFromJson (String book) throws ServiceException;
    public String updateOneFromJson(String book) throws ServiceException;
    public void deleteById(String isbn) throws ServiceException;
}
