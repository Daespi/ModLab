package com.example.Models.ShopCart.Appservices;


import com.example.Exceptions.ServiceException;
public interface ShopCartServices {

    String getCartByUserIdToJson(String userId) throws ServiceException;

    String addFromJson(String cartJson) throws ServiceException;

    String updateQuantityFromJson(String cartJson) throws ServiceException;

    void deleteByCartId(int cartId) throws ServiceException;

    void clearCartByUserId(String userId) throws ServiceException;
}
