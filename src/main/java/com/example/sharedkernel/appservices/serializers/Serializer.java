package com.example.sharedkernel.appservices.serializers;

import com.example.Exceptions.ServiceException;

public interface Serializer<T> {

    public String serialize ( T object ) throws ServiceException;

    public T deserialize(String s, Class<T> c) throws ServiceException;

}
