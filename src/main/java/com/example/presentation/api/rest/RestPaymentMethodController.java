package com.example.presentation.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Exceptions.ServiceException;
import com.example.Models.PaymentMethod.Appservices.PaymentMethodServices;

@RestController
@RequestMapping("/modlab/paymentMethod")
public class RestPaymentMethodController {

    @Autowired
    private PaymentMethodServices paymentMethodServices;

    @GetMapping(value = "/{paymentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getPaymentMethodById(@PathVariable String paymentId) {
        try {
            String json = paymentMethodServices.getByIdToJson(paymentId);
            return ResponseEntity.ok(json);
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addPaymentMethod(@RequestBody String paymentMethodJson) {
        try {
            String json = paymentMethodServices.addFromJson(paymentMethodJson);
            return ResponseEntity.ok(json);
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping(value = "/{paymentId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updatePaymentMethod(@PathVariable String paymentId, @RequestBody String paymentMethodJson) {
        try {
            String json = paymentMethodServices.updateOneFromJson(paymentId, paymentMethodJson);
            return ResponseEntity.ok(json);
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{paymentId}")
    public ResponseEntity<String> deletePaymentMethod(@PathVariable String paymentId) {
        try {
            paymentMethodServices.deleteById(paymentId);
            return ResponseEntity.ok("Método de pago eliminado correctamente.");
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
