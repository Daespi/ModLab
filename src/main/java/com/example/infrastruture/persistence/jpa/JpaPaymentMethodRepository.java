package com.example.infrastruture.persistence.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Models.PaymentMethod.DTO.PaymentMethodDTO;
import com.example.Models.PaymentMethod.Persistence.PaymentMethodRepository;

import jakarta.transaction.Transactional;

@Repository
public interface JpaPaymentMethodRepository extends JpaRepository<PaymentMethodDTO, String>, PaymentMethodRepository {

    List<PaymentMethodDTO> findByPaymentMethod(String paymentMethod);

    @Query(value = "SELECT p FROM PaymentMethodDTO p WHERE p.paymentMethod LIKE %:paymentMethod%")
    List<PaymentMethodDTO> findByPartialPaymentMethod(String paymentMethod);

    @Query(value = "SELECT count(*) FROM PaymentMethodDTO p WHERE p.paymentMethod LIKE %:paymentMethod%")
    Integer countByPartialPaymentMethod(String paymentMethod);

    @Transactional
    PaymentMethodDTO save(PaymentMethodDTO paymentMethod);

    @Transactional
    void deleteByUserId(String userId);
}
