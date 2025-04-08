package com.example.Models.User.Appservices;

import org.springframework.stereotype.Service;

import com.example.Exceptions.ServiceException;

@Service
public interface UserServices {
    String getByIdToJson(String userId) throws ServiceException;
    String addFromJson(String userJson) throws ServiceException;
    String updateOneFromJson(String userJson) throws ServiceException;
    void deleteById(String userId) throws ServiceException;
<<<<<<< HEAD
}
=======
}
>>>>>>> dev_alex
