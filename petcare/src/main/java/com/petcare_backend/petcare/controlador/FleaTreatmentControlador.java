package com.petcare_backend.petcare.controlador;

import com.petcare_backend.petcare.modelo.FleaTreatment;
import com.petcare_backend.petcare.modelo.Pet;
import com.petcare_backend.petcare.servicio.FleaTreatmentServicio;
import com.petcare_backend.petcare.servicio.PetServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flea-treatments")
public class FleaTreatmentControlador {

    private final FleaTreatmentServicio fleaTreatmentServicio;
    private final PetServicio petServicio;

    @Autowired
    public FleaTreatmentControlador(FleaTreatmentServicio fleaTreatmentService, PetServicio petServicio) {
        this.fleaTreatmentServicio = fleaTreatmentService;
        this.petServicio = petServicio;
    }

    @PostMapping
    public ResponseEntity<FleaTreatment> createFleaTreatment(@RequestBody FleaTreatment fleaTreatment, @RequestParam Long petId) {
        Pet pet = petServicio.findPetById(petId);
        if (pet == null) {
            return ResponseEntity.badRequest().build();
        }
        fleaTreatment.setPet(pet);
        FleaTreatment createdFleaTreatment = fleaTreatmentServicio.saveFleaTreatment(fleaTreatment);
        return ResponseEntity.ok(createdFleaTreatment);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FleaTreatment> getFleaTreatmentById(@PathVariable Long id) {
        FleaTreatment fleaTreatment = fleaTreatmentServicio.findFleaTreatmentById(id);
        return fleaTreatment != null ? ResponseEntity.ok(fleaTreatment) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<FleaTreatment>> getFleaTreatmentsByPet(@RequestParam Long petId) {
        Pet pet = petServicio.findPetById(petId);
        if (pet == null) {
            return ResponseEntity.badRequest().build();
        }
        List<FleaTreatment> fleaTreatments = fleaTreatmentServicio.findFleaTreatmentsByPet(pet);
        return ResponseEntity.ok(fleaTreatments);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFleaTreatment(@PathVariable Long id) {
        fleaTreatmentServicio.deleteFleaTreatment(id);
        return ResponseEntity.noContent().build();
    }
}
