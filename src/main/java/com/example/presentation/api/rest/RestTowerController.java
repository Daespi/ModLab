package com.example.presentation.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Exceptions.ServiceException;
import com.example.Models.Tower.Appservices.TowerServices;

@RestController
@RequestMapping("/modlab/tower")
public class RestTowerController {

    @Autowired
    private TowerServices towerServices;

    /**
     * GET - Endpoint de prueba
     */
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getHola() {
        return ResponseEntity.ok("hola desde Tower");
    }

    /**
     * GET - Obtener Tower por ID
     */
    @GetMapping(value = "/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getTowerById(@PathVariable String productId) {
        try {
            String json = towerServices.getByIdToJson(productId);
            return ResponseEntity.ok(json);
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * POST - Añadir nueva Tower
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addTower(@RequestBody String towerJson) {
        try {
            String json = towerServices.addFromJson(towerJson);
            return ResponseEntity.ok(json);
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * PUT - Actualizar Tower por ID
     */
    @PutMapping(value = "/{productId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateTower(@PathVariable String productId, @RequestBody String towerJson) {
        try {
            String json = towerServices.updateOneFromJson(productId, towerJson);
            return ResponseEntity.ok(json);
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * DELETE - Eliminar Tower por ID
     */
    @DeleteMapping("/{productId}")
    public ResponseEntity<String> deleteTower(@PathVariable String productId) {
        try {
            towerServices.deleteById(productId);
            return ResponseEntity.ok("Tower eliminada correctamente.");
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
