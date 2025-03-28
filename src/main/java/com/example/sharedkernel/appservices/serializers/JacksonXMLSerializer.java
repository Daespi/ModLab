package com.example.Models.sharedkernel.appservices.serializers;

import com.example.softlearning.applicationcore.entity.sharedkernel.model.exceptions.ServiceException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class JacksonXMLSerializer<T> implements Serializer<T> {

    private XmlMapper xmlMapper = new XmlMapper();

    public String serialize(T object) throws ServiceException {
        try {
            return this.xmlMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public T deserialize(String s, Class<T> c) throws ServiceException{
        try {
            return (T) this.xmlMapper.readValue(s, c);
        } catch (JsonProcessingException e) {
            throw new ServiceException(e.getMessage());
        }
    }

}
