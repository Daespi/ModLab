package com.example.Models.ShopCart.Appservices;

import org.springframework.stereotype.Service;

import com.example.Exceptions.ServiceException;

@Service
public interface ShopCartServices {

    String getCartByUserIdToJson(String userId) throws ServiceException;

    String addFromJson(String cartJson) throws ServiceException;

    String updateQuantityFromJson(String cartJson) throws ServiceException;

    void deleteByCartId(int cartId) throws ServiceException;

    void clearCartByUserId(String userId) throws ServiceException;
}
