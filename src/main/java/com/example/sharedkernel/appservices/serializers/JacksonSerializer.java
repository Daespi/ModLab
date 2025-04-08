package com.example.sharedkernel.appservices.serializers;

import com.example.Exceptions.ServiceException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonSerializer<T> implements Serializer<T> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String serialize(T object) throws ServiceException {
        try {
            return this.objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public T deserialize(String s, Class<T> c) throws ServiceException {
        try {
            return objectMapper.readValue(s, c);
        } catch (JsonProcessingException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}