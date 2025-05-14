package com.example.presentation.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Exceptions.ServiceException;
import com.example.Models.PowerSupply.Appservices.PowerSupplyServices;

@RestController
@RequestMapping("/modlab/powersupply") // <- Path en minúsculas, como el resto
public class RestPowerSupplyController {

    @Autowired
    private PowerSupplyServices powerSupplyServices;

    /**
     * GET - Endpoint de prueba
     */
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getHola() {
        return ResponseEntity.ok("hola desde PowerSupply");
    }

    /**
     * GET - Obtener PowerSupply por ID
     */
    @GetMapping(value = "/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getPowerSupplyById(@PathVariable String productId) {
        try {
            String json = powerSupplyServices.getByIdToJson(productId);
            return ResponseEntity.ok(json);
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * POST - Añadir nueva PowerSupply
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addPowerSupply(@RequestBody String powerSupplyJson) {
        try {
            String json = powerSupplyServices.addFromJson(powerSupplyJson);
            return ResponseEntity.ok(json);
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * PUT - Actualizar PowerSupply por ID
     */
    @PutMapping(value = "/{productId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updatePowerSupply(@PathVariable String productId, @RequestBody String powerSupplyJson) {
        try {
            String json = powerSupplyServices.updateOneFromJson(productId, powerSupplyJson);
            return ResponseEntity.ok(json);
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * DELETE - Eliminar PowerSupply por ID
     */
    @DeleteMapping("/{productId}")
    public ResponseEntity<String> deletePowerSupply(@PathVariable String productId) {
        try {
            powerSupplyServices.deleteById(productId);
            return ResponseEntity.ok("PowerSupply eliminado correctamente.");
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
