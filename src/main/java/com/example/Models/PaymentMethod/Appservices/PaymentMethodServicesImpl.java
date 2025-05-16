package com.example.Models.PaymentMethod.Appservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.Exceptions.BuildException;
import com.example.Exceptions.ServiceException;
import com.example.Models.PaymentMethod.DTO.PaymentMethodDTO;
import com.example.Models.PaymentMethod.MAPPERS.PaymentMethodMapper;
import com.example.Models.PaymentMethod.Persistence.PaymentMethodRepository;
import com.example.sharedkernel.appservices.serializers.Serializer;
import com.example.sharedkernel.appservices.serializers.Serializers;
import com.example.sharedkernel.appservices.serializers.SerializersCatalog;

import java.util.UUID;

@Controller
public class PaymentMethodServicesImpl implements PaymentMethodServices {

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    private Serializer<PaymentMethodDTO> serializer;

    protected PaymentMethodDTO getDTO(String paymentId) {
        return paymentMethodRepository.findById(paymentId).orElse(null);
    }

    protected PaymentMethodDTO getById(String paymentId) throws ServiceException {
        PaymentMethodDTO dto = this.getDTO(paymentId);
        if (dto == null) {
            throw new ServiceException("Payment method " + paymentId + " not found");
        }
        return dto;
    }

    protected PaymentMethodDTO checkInputData(String json) throws ServiceException {
        try {
            PaymentMethodDTO dto = this.serializer.deserialize(json, PaymentMethodDTO.class);
            PaymentMethodMapper.paymentFromDTO(dto); // Validación de negocio
            return dto;
        } catch (BuildException e) {
            throw new ServiceException("Error in payment method input: " + e.getMessage());
        }
    }

    protected PaymentMethodDTO newPaymentMethod(String json) throws ServiceException {
        PaymentMethodDTO dto = this.checkInputData(json);

        // Si no tiene ID, se genera
        if (dto.getPaymentId() == null || dto.getPaymentId().isBlank()) {
            dto.setPaymentId(UUID.randomUUID().toString().replace("-", "").substring(0, 32));
        }

        if (this.getDTO(dto.getPaymentId()) == null) {
            return paymentMethodRepository.save(dto);
        }

        throw new ServiceException("Payment method " + dto.getPaymentId() + " already exists");
    }

    protected PaymentMethodDTO updatePaymentMethod(String json) throws ServiceException {
        PaymentMethodDTO dto = this.checkInputData(json);
        this.getById(dto.getPaymentId());
        return paymentMethodRepository.save(dto);
    }

    @Override
    public String getByIdToJson(String paymentId) throws ServiceException {
        return SerializersCatalog.getInstance(Serializers.PAYMENTMETHOD_JSON)
                .serialize(this.getById(paymentId));
    }

    @Override
    public String addFromJson(String paymentMethodJson) throws ServiceException {
        this.serializer = SerializersCatalog.getInstance(Serializers.PAYMENTMETHOD_JSON);
        return serializer.serialize(this.newPaymentMethod(paymentMethodJson));
    }

    @Override
    public void deleteById(String paymentId) throws ServiceException {
        this.getById(paymentId);
        paymentMethodRepository.deleteById(paymentId);
    }

    @Override
    public String updateOneFromJson(String paymentId, String paymentMethodJson) throws ServiceException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateOneFromJson'");
    }
}
