package com.example.presentation.api.rest;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Models.User.Appservices.UserServices;

@RestController
@RequestMapping("/ModLab/User")
public class RestUserController {

    @Autowired
    UserServices userServices;

    @GetMapping(value = "/{user_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getJsonUserById(@PathVariable(value = "user_id") String user_id) {
        try {
            return ResponseEntity.ok(userServices.getByIdToJson(user_id));
        } catch (ServiceException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> newUserFromJson(@RequestBody String userdata) {
        try {
            return ResponseEntity.ok(userServices.addFromJson(userdata));
        } catch (ServiceException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PutMapping(value = "/{user_id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateUserFromJson(@PathVariable(value = "user_id") String user_id,
            @RequestBody String userdata) {
        try {
            return ResponseEntity.ok(userServices.updateOneFromJson(userdata));
        } catch (ServiceException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @DeleteMapping("/{user_id}")
    public ResponseEntity<String> deleteByID(@PathVariable(value = "user_id") String user_id) {
        try {
            userServices.deleteById(user_id);
            return ResponseEntity.ok().build();
        } catch (ServiceException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }
}