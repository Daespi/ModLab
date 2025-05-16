package com.example.presentation.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Exceptions.ServiceException;
import com.example.Models.Motherboard.Appservices.MotherBoardServices;

@RestController
@RequestMapping("/modlab/motherboard") // <- ¡Ojo! Este path es sensible a mayúsculas/minúsculas
public class RestMotherboardController {

    @Autowired
    private MotherBoardServices motherBoardServices;

    /**
     * GET - Endpoint de prueba
     */
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getHola() {
        return ResponseEntity.ok("hola desde MotherBoard");
    }

    /**
     * GET - Obtener MotherBoard por ID
     */
    @GetMapping(value = "/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getMotherBoardById(@PathVariable String productId) {
        try {
            String json = motherBoardServices.getByIdToJson(productId);
            return ResponseEntity.ok(json);
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * POST - Añadir nueva MotherBoard
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addMotherBoard(@RequestBody String motherBoardJson) {
        try {
            String json = motherBoardServices.addFromJson(motherBoardJson);
            return ResponseEntity.ok(json);
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * PUT - Actualizar MotherBoard por ID
     */
    @PutMapping(value = "/{productId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateMotherBoard(@PathVariable String productId, @RequestBody String motherBoardJson) {
        try {
            String json = motherBoardServices.updateOneFromJson(productId, motherBoardJson);
            return ResponseEntity.ok(json);
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * DELETE - Eliminar MotherBoard por ID
     */
    @DeleteMapping("/{productId}")
    public ResponseEntity<String> deleteMotherBoard(@PathVariable String productId) {
        try {
            motherBoardServices.deleteById(productId);
            return ResponseEntity.ok("MotherBoard eliminada correctamente.");
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
