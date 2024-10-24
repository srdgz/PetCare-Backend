package com.petcare_backend.petcare.controlador;

import com.petcare_backend.petcare.modelo.Medication;
import com.petcare_backend.petcare.modelo.Pet;
import com.petcare_backend.petcare.servicio.MedicationServicio;
import com.petcare_backend.petcare.servicio.PetServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medications")
@CrossOrigin(origins = "http://localhost:4200")
public class MedicationControlador {

    private final MedicationServicio medicationServicio;
    private final PetServicio petServicio;

    @Autowired
    public MedicationControlador(MedicationServicio medicationService, PetServicio petServicio) {
        this.medicationServicio = medicationService;
        this.petServicio = petServicio;
    }

    @PostMapping
    public ResponseEntity<Medication> createMedication(@RequestBody Medication medication, @RequestParam Long petId) {
        Pet pet = petServicio.findPetById(petId);
        if (pet == null) {
            return ResponseEntity.badRequest().build();
        }
        medication.setPet(pet);
        Medication createdMedication = medicationServicio.saveMedication(medication);
        return ResponseEntity.ok(createdMedication);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medication> getMedicationById(@PathVariable Long id) {
        Medication medication = medicationServicio.findMedicationById(id);
        return medication != null ? ResponseEntity.ok(medication) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Medication>> getMedicationsByPet(@RequestParam Long petId) {
        Pet pet = petServicio.findPetById(petId);
        if (pet == null) {
            return ResponseEntity.badRequest().build();
        }
        List<Medication> medications = medicationServicio.findMedicationsByPet(pet);
        return ResponseEntity.ok(medications);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedication(@PathVariable Long id) {
        medicationServicio.deleteMedication(id);
        return ResponseEntity.noContent().build();
    }
}
