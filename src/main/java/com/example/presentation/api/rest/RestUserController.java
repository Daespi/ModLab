package com.example.presentation.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Exceptions.ServiceException;
import com.example.Models.User.Appservices.UserServices;

@RestController
@RequestMapping("/modlab/User")
public class RestUserController {

    @Autowired
    private UserServices userServices;

    /**
     * GET - Obtener un usuario por ID (devuelve JSON)
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
     * POST - Crear un nuevo usuario desde JSON
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> newUserFromJson(@RequestBody String userdata) {
        try {
            String json = userServices.addFromJson(userdata);
            return ResponseEntity.ok(json);
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * PUT - Actualizar un usuario existente
     */
    @PutMapping(value = "/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateUserFromJson(@PathVariable String userId, @RequestBody String userdata) {
        try {
            String json = userServices.updateOneFromJson(userdata);
            return ResponseEntity.ok(json);
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * DELETE - Eliminar un usuario por ID
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

