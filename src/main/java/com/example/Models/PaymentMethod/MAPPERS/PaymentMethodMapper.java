package com.example.Models.PaymentMethod.MAPPERS;

import com.example.Exceptions.BuildException;
import com.example.Models.PaymentMethod.DTO.PaymentMethodDTO;
import com.example.Models.PaymentMethod.Entity.PaymentMethod;

public class PaymentMethodMapper {

    public static PaymentMethod paymentFromDTO(PaymentMethodDTO dto) throws BuildException {
        return PaymentMethod.getInstance(
                dto.getPaymentMethod(),
                dto.getCardNumber(),
                dto.getCardExpiry(),
                dto.getCardCvv(),
                dto.getUserId()
        );
    }

    public static PaymentMethodDTO dtoFromPayment(PaymentMethod payment) {
        return new PaymentMethodDTO(
                payment.getPaymentId(),
                payment.getPaymentMethod(),
                payment.getCardNumber(),
                payment.getCardExpiry(),
                payment.getCardCvv(),
                payment.getUserId()
        );
    }
}
