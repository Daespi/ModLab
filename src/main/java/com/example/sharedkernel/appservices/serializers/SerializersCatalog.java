package com.example.Models.sharedkernel.appservices.serializers;

import java.util.TreeMap;

import com.example.softlearning.applicationcore.entity.book.dtos.BookDTO;
import com.example.softlearning.applicationcore.entity.client.dtos.ClientDTO;

public class SerializersCatalog {

    private static TreeMap<Serializers, Serializer> catalog = new TreeMap<>();   

    private static void loadCatalog(){
        catalog.put(Serializers.BOOK_JSON, new JacksonSerializer<BookDTO>());
        catalog.put(Serializers.BOOK_XML, new JacksonXMLSerializer<BookDTO>());        
        catalog.put(Serializers.CLIENT_JSON, new JacksonSerializer<ClientDTO>());
        catalog.put(Serializers.CLIENT_XML, new JacksonXMLSerializer<ClientDTO>());    
        
    }  

    public static Serializer getInstance(Serializers type){
        if (catalog.isEmpty()){
            loadCatalog();
        }      
        return catalog.get(type);
    }   
}
