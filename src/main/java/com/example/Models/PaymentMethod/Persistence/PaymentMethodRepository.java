package com.example.Models.PaymentMethod.Persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Models.PaymentMethod.DTO.PaymentMethodDTO;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethodDTO, String> {

    List<PaymentMethodDTO> findByUserId(String userId);

    List<PaymentMethodDTO> findByPaymentMethodContaining(String paymentMethod);

    Integer countByPaymentMethodContaining(String paymentMethod);
}
