package com.example.sharedkernel.appservices.serializers;
import java.util.List;
import com.example.Exceptions.ServiceException;

public interface Serializer<T> {
    String serialize(T object) throws ServiceException;
    T deserialize(String s, Class<T> c) throws ServiceException;


    String serializeList(List<T> list) throws ServiceException;

    T deserialize(String json) throws ServiceException;
}