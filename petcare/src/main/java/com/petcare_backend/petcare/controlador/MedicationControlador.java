package com.petcare_backend.petcare.controlador;

import com.petcare_backend.petcare.modelo.Medication;
import com.petcare_backend.petcare.servicio.MedicationServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medications")
public class MedicationControlador {

    private final MedicationServicio medicationServicio;

    @Autowired
    public MedicationControlador(MedicationServicio medicationService) {
        this.medicationServicio = medicationService;
    }

    @PostMapping
    public ResponseEntity<Medication> createMedication(@RequestBody Medication medication) {
        Medication createdMedication = medicationServicio.saveMedication(medication);
        return ResponseEntity.ok(createdMedication);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medication> getMedicationById(@PathVariable Long id) {
        Medication medication = medicationServicio.findMedicationById(id);
        return medication != null ? ResponseEntity.ok(medication) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<Medication> getAllMedications() {
        return medicationServicio.findAllMedications();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedication(@PathVariable Long id) {
        medicationServicio.deleteMedication(id);
        return ResponseEntity.noContent().build();
    }
}
