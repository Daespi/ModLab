package com.example.presentation.api.rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Exceptions.ServiceException;
import com.example.Models.ShippingAddress.Appservices.ShippingAddressServices;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/modlab/ShippingAddress")
public class RestShippingAddressController {

    @Autowired
    private ShippingAddressServices shippingAddressServices;

    /**
     * GET - Obtener dirección por ID
     */
    @GetMapping(value = "/{addressId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getJsonById(@PathVariable int addressId) {
        try {
            String json = shippingAddressServices.getByIdToJson(addressId);
            return ResponseEntity.ok(json);
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * POST - Crear nueva dirección
     */
    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> newAddressFromJson(@RequestBody String addressJson) {
        try {
            String json = shippingAddressServices.addFromJson(addressJson);
            return ResponseEntity.ok(json);
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * PUT - Actualizar dirección existente
     */
    @PutMapping(value = "/{addressId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateAddressFromJson(@PathVariable int addressId,
                                                        @RequestBody String addressJson) {
        try {
            String json = shippingAddressServices.updateOneFromJson(addressJson);
            return ResponseEntity.ok(json);
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * DELETE - Eliminar dirección por ID
     */
    @DeleteMapping("/{addressId}")
    public ResponseEntity<String> deleteById(@PathVariable int addressId) {
        try {
            shippingAddressServices.deleteById(addressId);
            return ResponseEntity.ok("Dirección eliminada correctamente.");
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * GET - Obtener carrito de un usuario por ID (JSON)
     */
    @GetMapping(value = "/user/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getCartByUser(@PathVariable String userId) {
        try {
            String json = shippingAddressServices.getAddressByUserIdToJson(userId);
            return ResponseEntity.ok(json);
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

        
}
