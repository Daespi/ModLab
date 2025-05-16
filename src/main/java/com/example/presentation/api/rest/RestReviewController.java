package com.example.presentation.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Exceptions.ServiceException;
import com.example.Models.Review.Appservices.ReviewServices;

@RestController
@RequestMapping("/modlab/Review")
public class RestReviewController {

    @Autowired
    private ReviewServices reviewServices;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getHola() {
        return ResponseEntity.ok("hola");
    }

    /**
     * GET - Obtener todas las reseñas de un usuario
     */
    @GetMapping(value = "/user/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getReviewsByUserId(@PathVariable String userId) {
        try {
            String json = reviewServices.getByUserIdToJson(userId);
            return ResponseEntity.ok(json);
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * GET - Obtener una reseña por ID
     */
    @GetMapping(value = "/{reviewId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getReviewById(@PathVariable int reviewId) {
        try {
            String json = reviewServices.getByIdToJson(reviewId);
            return ResponseEntity.ok(json);
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * POST - Crear una nueva reseña desde JSON
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> newReviewFromJson(@RequestBody String reviewData) {
        try {
            String json = reviewServices.addFromJson(reviewData);
            return ResponseEntity.ok(json);
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * PUT - Actualizar una reseña existente
     */
    @PutMapping(value = "/{reviewId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateReviewFromJson(@PathVariable int reviewId, @RequestBody String reviewData) {
        try {
            String json = reviewServices.updateOneFromJson(reviewId, reviewData);
            return ResponseEntity.ok(json);
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * DELETE - Eliminar una reseña por ID
     */
    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteById(@PathVariable int reviewId) {
        try {
            reviewServices.deleteById(reviewId);
            return ResponseEntity.ok("Reseña eliminada correctamente.");
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}