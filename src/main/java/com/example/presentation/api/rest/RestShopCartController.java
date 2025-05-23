package com.example.presentation.api.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Exceptions.ServiceException;
import com.example.Models.ShopCart.Appservices.ShopCartServices;

@RestController
@RequestMapping("/modlab/ShopCart")
public class RestShopCartController {

    @Autowired
    private ShopCartServices shopCartServices;

    /**
     * GET - Obtener carrito de un usuario por ID (JSON)
     */
    @GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getCartByUser(@PathVariable String userId) {
        try {
            String json = shopCartServices.getCartByUserIdToJson(userId);
            return ResponseEntity.ok(json);
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * POST - Añadir producto al carrito desde JSON
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addProductToCart(@RequestBody String cartJson) {
        try {
            String json = shopCartServices.addFromJson(cartJson);
            return ResponseEntity.ok(json);
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * PUT - Actualizar cantidad de producto en el carrito
     */
    @PutMapping(value = "/{cartId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateCartItem(@PathVariable int cartId, @RequestBody String cartJson) {
        try {
            String json = shopCartServices.updateQuantityFromJson(cartJson);
            return ResponseEntity.ok(json);
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

@DeleteMapping("/{cartId}")
public ResponseEntity<Map<String, String>> deleteItem(@PathVariable int cartId) {
    try {
        shopCartServices.deleteByCartId(cartId);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Elemento eliminado del carrito.");
        return ResponseEntity.ok(response);
    } catch (ServiceException e) {
        Map<String, String> error = new HashMap<>();
        error.put("error", e.getMessage());
        return ResponseEntity.badRequest().body(error);
    }
}


@DeleteMapping("/user/{userId}")
public ResponseEntity<Map<String, String>> clearUserCart(@PathVariable String userId) {
    try {
        shopCartServices.clearCartByUserId(userId);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Carrito vaciado correctamente.");
        return ResponseEntity.ok(response);
    } catch (ServiceException e) {
        Map<String, String> error = new HashMap<>();
        error.put("error", e.getMessage());
        return ResponseEntity.badRequest().body(error);
    }
}

}
