package com.example.presentation.api.rest;

import com.example.Exceptions.ServiceException;
import com.example.Models.Product.Appservices.ProductServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/modlab/products")
public class RestProductController {

    @Autowired
    private ProductServices productServices;

    @GetMapping("/{id}")
    public ResponseEntity<String> getProductById(@PathVariable("id") String productId) {
        try {
            String productJson = productServices.getByIdToJson(productId);
            return ResponseEntity.ok(productJson);
        } catch (ServiceException e) {
            return ResponseEntity.status(404).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }
}
