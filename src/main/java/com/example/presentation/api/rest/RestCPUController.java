package com.example.presentation.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Exceptions.ServiceException;
import com.example.Models.CPU.Appservices.CPUServices;

@RestController
@RequestMapping("/modlab/CPU")
public class RestCPUController {

    @Autowired
    private CPUServices cpuServices;

    /**
     * GET - Endpoint de prueba
     */
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getHola() {
        return ResponseEntity.ok("hola desde CPU");
    }

    /**
     * GET - Obtener CPU por ID
     */
    @GetMapping(value = "/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getCpuById(@PathVariable String productId) {
        try {
            String json = cpuServices.getByIdToJson(productId);
            return ResponseEntity.ok(json);
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * POST - Añadir nueva CPU
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addCpu(@RequestBody String cpuJson) {
        try {
            String json = cpuServices.addFromJson(cpuJson);
            return ResponseEntity.ok(json);
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * PUT - Actualizar CPU por ID
     */
    @PutMapping(value = "/{productId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateCpu(@PathVariable String productId, @RequestBody String cpuJson) {
        try {
            String json = cpuServices.updateOneFromJson(productId, cpuJson);
            return ResponseEntity.ok(json);
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * DELETE - Eliminar CPU por ID
     */
    @DeleteMapping("/{productId}")
    public ResponseEntity<String> deleteCpu(@PathVariable String productId) {
        try {
            cpuServices.deleteById(productId);
            return ResponseEntity.ok("CPU eliminada correctamente.");
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
