package com.example.presentation.api.rest;

import com.example.Exceptions.ServiceException;
import com.example.Models.OrderDetail.Appservices.OrderDetailServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/modlab/orderdetail")
public class RestOrderDetailController {

    @Autowired
    private OrderDetailServices orderDetailServices;

    /**
     * GET - Mensaje de prueba
     */
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getHola() {
        return ResponseEntity.ok("Hola desde OrderDetail");
    }

    /**
     * GET - Obtener un OrderDetail por ID
     */
    @GetMapping(value = "/{orderDetailId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getOrderDetailById(@PathVariable String orderDetailId) {
        try {
            String json = orderDetailServices.getByIdToJson(orderDetailId);
            return ResponseEntity.ok(json);
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * GET - Obtener todos los OrderDetails de una orden
     */
    @GetMapping(value = "/order/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getOrderDetailsByOrderId(@PathVariable String orderId) {
        try {
            String json = orderDetailServices.getByOrderIdToJson(orderId);
            return ResponseEntity.ok(json);
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * POST - Crear un nuevo OrderDetail desde JSON
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> newOrderDetailFromJson(@RequestBody String detailJson) {
        try {
            String json = orderDetailServices.addFromJson(detailJson);
            return ResponseEntity.ok(json);
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * PUT - Actualizar un OrderDetail existente
     */
    @PutMapping(value = "/{orderDetailId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateOrderDetailFromJson(@PathVariable String orderDetailId, @RequestBody String detailJson) {
        try {
            String json = orderDetailServices.updateOneFromJson(detailJson);
            return ResponseEntity.ok(json);
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * DELETE - Eliminar un OrderDetail por ID
     */
    @DeleteMapping("/{orderDetailId}")
    public ResponseEntity<String> deleteOrderDetailById(@PathVariable String orderDetailId) {
        try {
            orderDetailServices.deleteById(orderDetailId);
            return ResponseEntity.ok("OrderDetail eliminado correctamente.");
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * DELETE - Eliminar todos los detalles de una orden
     */
    @DeleteMapping("/order/{orderId}")
    public ResponseEntity<String> deleteAllOrderDetailsByOrderId(@PathVariable String orderId) {
        try {
            orderDetailServices.deleteAllByOrderId(orderId);
            return ResponseEntity.ok("Detalles de la orden eliminados correctamente.");
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
