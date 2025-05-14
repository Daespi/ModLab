package com.example.presentation.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Exceptions.ServiceException;
import com.example.Models.HardDrive.Appservices.HardDriveServices;

@RestController
@RequestMapping("/modlab/harddrive")
public class RestHardDriveController {

    @Autowired
    private HardDriveServices hardDriveServices;

    /**
     * GET - Endpoint de prueba
     */
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getHola() {
        return ResponseEntity.ok("hola desde HardDrive");
    }

    /**
     * GET - Obtener HardDrive por ID
     */
    @GetMapping(value = "/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getHardDriveById(@PathVariable String productId) {
        try {
            String json = hardDriveServices.getByIdToJson(productId);
            return ResponseEntity.ok(json);
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * POST - Añadir nuevo HardDrive
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addHardDrive(@RequestBody String hardDriveJson) {
        try {
            String json = hardDriveServices.addFromJson(hardDriveJson);
            return ResponseEntity.ok(json);
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * PUT - Actualizar HardDrive por ID
     */
    @PutMapping(value = "/{productId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateHardDrive(@PathVariable String productId, @RequestBody String hardDriveJson) {
        try {
            String json = hardDriveServices.updateOneFromJson(productId, hardDriveJson);
            return ResponseEntity.ok(json);
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * DELETE - Eliminar HardDrive por ID
     */
    @DeleteMapping("/{productId}")
    public ResponseEntity<String> deleteHardDrive(@PathVariable String productId) {
        try {
            hardDriveServices.deleteById(productId);
            return ResponseEntity.ok("HardDrive eliminado correctamente.");
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
