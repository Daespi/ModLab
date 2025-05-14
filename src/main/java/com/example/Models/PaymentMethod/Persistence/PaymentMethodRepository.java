package com.example.Models.PaymentMethod.Persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.Models.PaymentMethod.DTO.PaymentMethodDTO;

@Repository
public interface PaymentMethodRepository {

    Optional<PaymentMethodDTO> findById(String paymentId);

    Optional<PaymentMethodDTO> findByUserId(String userId); // CORREGIDO: antes devolvía List

    List<PaymentMethodDTO> findByPaymentMethodContaining(String paymentMethod);

    Integer countByPaymentMethodContaining(String paymentMethod);

    PaymentMethodDTO save(PaymentMethodDTO paymentMethod);

    void deleteById(String paymentId);
}
