package com.example.sharedkernel.appservices.serializers;

import java.util.TreeMap;

import com.example.Models.CPU.DTO.CPUDTO;
// import com.example.Models.GraphicCard.DTO.GraphicCardDTO;
// import com.example.Models.HardDrive.DTO.HardDriveDTO;
import com.example.Models.Motherboard.DTO.MotherBoardDTO;
import com.example.Models.PaymentMethod.DTO.PaymentMethodDTO;
// import com.example.Models.PowerSupply.DTO.PowerSupplyDTO;
// import com.example.Models.Ram.DTO.RamDTO;
import com.example.Models.ShippingAddress.DTO.ShippingAddressDTO;
// import com.example.Models.Tower.DTO.TowerDTO;
import com.example.Models.User.DTO.UserDTO;
// import com.example.Models.Ventilation.DTO.VentilationDTO;

public class SerializersCatalog {

    private static final TreeMap<Serializers, Serializer<?>> catalog = new TreeMap<>();

    private static void loadCatalog() {
        catalog.put(Serializers.USER_JSON, new JacksonSerializer<UserDTO>());
        catalog.put(Serializers.SHIPPINGADDRESS_JSON, new JacksonSerializer<ShippingAddressDTO>());
        catalog.put(Serializers.CPU_JSON, new JacksonSerializer<CPUDTO>());
        // catalog.put(Serializers.GraphicCard_JSON, new JacksonSerializer<GraphicCardDTO>());
        // catalog.put(Serializers.HardDrive_JSON, new JacksonSerializer<HardDriveDTO>());
        catalog.put(Serializers.Motherboard_JSON, new JacksonSerializer<MotherBoardDTO>());
        // catalog.put(Serializers.PowerSupply_JSON, new JacksonSerializer<PowerSupplyDTO>());
        // catalog.put(Serializers.Ram_JSON, new JacksonSerializer<RamDTO>());
        // catalog.put(Serializers.Tower_JSON, new JacksonSerializer<TowerDTO>());
        // catalog.put(Serializers.Ventilation_JSON, new JacksonSerializer<VentilationDTO>());
        catalog.put(Serializers.PAYMENTMETHOD_JSON, new JacksonSerializer<PaymentMethodDTO>());
        
    }

    public static Serializer getInstance(Serializers type) {
        if (catalog.isEmpty()) {
            loadCatalog();
        }
        return catalog.get(type);
    }

}

