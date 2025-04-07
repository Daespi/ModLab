package com.example.Models.Review.Appservices;

import org.springframework.stereotype.Service;

import com.example.Exceptions.ServiceException;

@Service
public interface ReviewServices {
    public String getByIdToJson (int reviewId) throws ServiceException;
    public String addFromJson (String comment) throws ServiceException;
    public String updateOneFromJson(String comment) throws ServiceException;
    public void deleteById(int reviewId) throws ServiceException;
}

