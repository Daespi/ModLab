package com.example.presentation.api.rest;

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

    /**
     * DELETE - Eliminar un producto del carrito por ID
     */
    @DeleteMapping("/{cartId}")
    public ResponseEntity<String> deleteItem(@PathVariable int cartId) {
        try {
            shopCartServices.deleteByCartId(cartId);
            return ResponseEntity.ok("Elemento eliminado del carrito.");
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * DELETE - Vaciar el carrito completo de un usuario
     */
    @DeleteMapping("/user/{userId}")
    public ResponseEntity<String> clearUserCart(@PathVariable String userId) {
        try {
            shopCartServices.clearCartByUserId(userId);
            return ResponseEntity.ok("Carrito vaciado correctamente.");
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
