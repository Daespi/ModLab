// package com.example.presentation.api.rest;

// import com.example.Exceptions.ServiceException;
// import com.example.Models.GraphicCard.Appservices.GraphicCardServices;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/modlab/graphicCard")
// public class RestGraphicCardController {

//     @Autowired
//     private GraphicCardServices graphicCardServices;

//     // Obtener tarjeta gráfica por ID
//     @GetMapping("/{productId}")
//     public ResponseEntity<String> getGraphicCardById(@PathVariable String productId) {
//         try {
//             String graphicCardJson = graphicCardServices.getByIdToJson(productId);
//             return new ResponseEntity<>(graphicCardJson, HttpStatus.OK);
//         } catch (ServiceException e) {
//             return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
//         }
//     }

//     // Añadir nueva tarjeta gráfica
//     @PostMapping
//     public ResponseEntity<String> addGraphicCard(@RequestBody String graphicCardJson) {
//         try {
//             String result = graphicCardServices.addFromJson(graphicCardJson);
//             return new ResponseEntity<>(result, HttpStatus.CREATED);
//         } catch (ServiceException e) {
//             return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//         }
//     }

//     // Actualizar una tarjeta gráfica existente
//     @PutMapping("/{productId}")
//     public ResponseEntity<String> updateGraphicCard(@PathVariable String productId, @RequestBody String graphicCardJson) {
//         try {
//             String result = graphicCardServices.updateOneFromJson(productId, graphicCardJson);
//             return new ResponseEntity<>(result, HttpStatus.OK);
//         } catch (ServiceException e) {
//             return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//         }
//     }

//     // Eliminar una tarjeta gráfica por ID
//     @DeleteMapping("/{productId}")
//     public ResponseEntity<String> deleteGraphicCard(@PathVariable String productId) {
//         try {
//             graphicCardServices.deleteById(productId);
//             return new ResponseEntity<>("Graphic Card deleted successfully", HttpStatus.NO_CONTENT);
//         } catch (ServiceException e) {
//             return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
//         }
//     }
// }
