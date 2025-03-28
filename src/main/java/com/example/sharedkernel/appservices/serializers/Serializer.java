package com.example.Models.sharedkernel.appservices.serializers;

import com.example.softlearning.applicationcore.entity.sharedkernel.model.exceptions.ServiceException;

public interface Serializer<T> {

    public String serialize ( T object ) throws ServiceException;

    public T deserialize(String s, Class<T> c) throws ServiceException;

}
