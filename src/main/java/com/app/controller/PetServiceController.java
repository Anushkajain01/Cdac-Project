package com.app.controller;

import com.app.dto.PetServiceDTO;
import com.app.service.PetServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/petservices")
public class PetServiceController {

    @Autowired
    private PetServiceService petServiceService;

    @PostMapping
    public ResponseEntity<PetServiceDTO> createService(@RequestBody PetServiceDTO petServiceDTO) {
        PetServiceDTO createdService = petServiceService.createService(petServiceDTO);
        return ResponseEntity.ok(createdService);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetServiceDTO> getServiceById(@PathVariable Integer id) {
        PetServiceDTO service = petServiceService.getServiceById(id);
        return ResponseEntity.ok(service);
    }

    @GetMapping
    public ResponseEntity<List<PetServiceDTO>> getAllServices() {
        List<PetServiceDTO> services = petServiceService.getAllServices();
        return ResponseEntity.ok(services);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PetServiceDTO> updateService(@PathVariable Integer id, @RequestBody PetServiceDTO petServiceDTO) {
        PetServiceDTO updatedService = petServiceService.updateService(id, petServiceDTO);
        return ResponseEntity.ok(updatedService);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable Integer id) {
        petServiceService.deleteService(id);
        return ResponseEntity.noContent().build();
    }
}
