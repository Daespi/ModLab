// package com.example.presentation.api.rest;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.MediaType;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import com.example.Exceptions.ServiceException;
// import com.example.Models.Ram.Appservices.RamServices;

// @RestController
// @RequestMapping("/modlab/ram")
// public class RestRamController {

//     @Autowired
//     private RamServices ramServices;

//     /**
//      * GET - Endpoint de prueba
//      */
//     @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
//     public ResponseEntity<String> getHola() {
//         return ResponseEntity.ok("hola desde Ram");
//     }

//     /**
//      * GET - Obtener Ram por ID
//      */
//     @GetMapping(value = "/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
//     public ResponseEntity<String> getRamById(@PathVariable String productId) {
//         try {
//             String json = ramServices.getByIdToJson(productId);
//             return ResponseEntity.ok(json);
//         } catch (ServiceException e) {
//             return ResponseEntity.badRequest().body(e.getMessage());
//         }
//     }

//     /**
//      * POST - Añadir nueva Ram
//      */
//     @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//     public ResponseEntity<String> addRam(@RequestBody String ramJson) {
//         try {
//             String json = ramServices.addFromJson(ramJson);
//             return ResponseEntity.ok(json);
//         } catch (ServiceException e) {
//             return ResponseEntity.badRequest().body(e.getMessage());
//         }
//     }

//     /**
//      * PUT - Actualizar Ram por ID
//      */
//     @PutMapping(value = "/{productId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//     public ResponseEntity<String> updateRam(@PathVariable String productId, @RequestBody String ramJson) {
//         try {
//             String json = ramServices.updateOneFromJson(productId, ramJson);
//             return ResponseEntity.ok(json);
//         } catch (ServiceException e) {
//             return ResponseEntity.badRequest().body(e.getMessage());
//         }
//     }

//     /**
//      * DELETE - Eliminar Ram por ID
//      */
//     @DeleteMapping("/{productId}")
//     public ResponseEntity<String> deleteRam(@PathVariable String productId) {
//         try {
//             ramServices.deleteById(productId);
//             return ResponseEntity.ok("Ram eliminada correctamente.");
//         } catch (ServiceException e) {
//             return ResponseEntity.badRequest().body(e.getMessage());
//         }
//     }
// }
