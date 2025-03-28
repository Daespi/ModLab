package com.example.Models.sharedkernel.appservices.serializers;

import com.example.softlearning.applicationcore.entity.sharedkernel.model.exceptions.ServiceException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonSerializer<T> implements Serializer<T> {
    private ObjectMapper objectMapper = new ObjectMapper();

    public String serialize(T object) throws ServiceException {
        try {
            return this.objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public T deserialize(String s, Class<T> c) throws ServiceException{
        try {
            return (T) this.objectMapper.readValue(s, c);
        } catch (JsonProcessingException e) {
            throw new ServiceException(e.getMessage());
        }
    }

}
