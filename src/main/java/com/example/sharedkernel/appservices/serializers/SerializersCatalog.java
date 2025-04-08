package com.example.sharedkernel.appservices.serializers;

import java.util.TreeMap;

import com.example.Models.ShippingAddress.DTO.ShippingAddressDTO;
import com.example.Models.User.DTO.UserDTO;

public class SerializersCatalog {

    private static final TreeMap<Serializers, Serializer<?>> catalog = new TreeMap<>();

    private static void loadCatalog() {
        catalog.put(Serializers.USER_JSON, new JacksonSerializer<UserDTO>());
        catalog.put(Serializers.SHIPPINGADDRESS_JSON, new JacksonSerializer<ShippingAddressDTO>());
    }

    public static Serializer getInstance(Serializers type) {
        if (catalog.isEmpty()) {
            loadCatalog();
        }
        return catalog.get(type);
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> dev_alex
