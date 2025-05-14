package com.example.presentation.api.rest;

import com.example.Exceptions.ServiceException;
import com.example.Models.Ventilation.Appservices.VentilationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/modlab/ventilation")
public class RestVentilationController {

    @Autowired
    private VentilationServices ventilationServices;

    @GetMapping("/{productId}")
    public String getVentilationById(@PathVariable String productId) throws ServiceException {
        return ventilationServices.getByIdToJson(productId);
    }

    @PostMapping
    public String addVentilation(@RequestBody String ventilationJson) throws ServiceException {
        return ventilationServices.addFromJson(ventilationJson);
    }

    @PutMapping("/{productId}")
    public String updateVentilation(@PathVariable String productId, @RequestBody String ventilationJson) throws ServiceException {
        return ventilationServices.updateOneFromJson(productId, ventilationJson);
    }

    @DeleteMapping("/{productId}")
    public void deleteVentilation(@PathVariable String productId) throws ServiceException {
        ventilationServices.deleteById(productId);
    }
}
