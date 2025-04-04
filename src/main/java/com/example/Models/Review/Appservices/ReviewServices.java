package com.example.Models.Review.Appservices;

import org.springframework.stereotype.Service;

import com.example.Exceptions.ServiceException;

public class ReviewServices {
    public String getByIdToJson (int reviewId) throws ServiceException;
    public String addFromJson (String review) throws ServiceException;
    public String updateOneFromJson(String review) throws ServiceException;
    public void deleteById(int reviewId) throws ServiceException;
}

