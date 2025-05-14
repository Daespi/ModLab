package com.example.presentation.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Exceptions.ServiceException;
import com.example.Models.Order.Appservices.OrderServices;

@RestController
@RequestMapping("/modlab/order")
public class RestOrderController {

    @Autowired
    private OrderServices orderServices;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getHola() {
        return ResponseEntity.ok("hola");
    }

    /**
     * GET - Obtener una orden por ID (devuelve JSON)
     */
    @GetMapping(value = "/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getJsonOrderById(@PathVariable String orderId) {
        try {
            String json = orderServices.getByIdToJson(orderId);
            return ResponseEntity.ok(json);
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * POST - Crear una nueva orden desde JSON
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> newOrderFromJson(@RequestBody String orderJson) {
        try {
            String json = orderServices.addFromJson(orderJson);
            return ResponseEntity.ok(json);
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * PUT - Actualizar una orden existente
     */
    @PutMapping(value = "/{orderId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateOrderFromJson(@PathVariable String orderId, @RequestBody String orderJson) {
        try {
            String json = orderServices.updateOneFromJson(orderJson);
            return ResponseEntity.ok(json);
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * DELETE - Eliminar una orden por ID
     */
    @DeleteMapping("/{orderId}")
    public ResponseEntity<String> deleteById(@PathVariable String orderId) {
        try {
            orderServices.deleteById(orderId);
            return ResponseEntity.ok("Orden eliminada correctamente.");
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
