package com.example.presentation.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Exceptions.ServiceException;
import com.example.Models.User.Appservices.UserServices;

@RestController
@RequestMapping("/modlab/User")
public class RestUserController {

    @Autowired
    private UserServices userServices;

    /**
     * GET - Endpoint de prueba
     */
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getHola() {
        return ResponseEntity.ok("hola");
    }

    /**
     * GET - Obtener un usuario por ID
     */
    @GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getJsonUserById(@PathVariable String userId) {
        try {
            String json = userServices.getByIdToJson(userId);
            return ResponseEntity.ok(json);
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * POST - Registrar un nuevo usuario
     */
    @PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> registerUser(@RequestBody String json) {
        try {
            String createdUserJson = userServices.addFromJson(json);
            return ResponseEntity.ok(createdUserJson);
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * PUT - Actualizar usuario existente
     */
    @PutMapping(value = "/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateUserFromJson(@PathVariable String userId, @RequestBody String json) {
        try {
            // Validación obligatoria del ID antes de actualizar
            userServices.getById(userId);
            String updatedUserJson = userServices.updateOneFromJson(json);
            return ResponseEntity.ok(updatedUserJson);
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * DELETE - Eliminar usuario por ID
     */
    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteByID(@PathVariable String userId) {
        try {
            userServices.deleteById(userId);
            return ResponseEntity.ok("Usuario eliminado correctamente.");
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
