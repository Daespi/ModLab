package com.example.sharedkernel.appservices.serializers;

import com.example.Exceptions.ServiceException;

public interface Serializer<T> {
    String serialize(T object) throws ServiceException;
    T deserialize(String s, Class<T> c) throws ServiceException;
}
