package com.petcare_backend.petcare.controlador;

import com.petcare_backend.petcare.modelo.FleaTreatment;
import com.petcare_backend.petcare.servicio.FleaTreatmentServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flea-treatments")
public class FleaTreatmentControlador {

    private final FleaTreatmentServicio fleaTreatmentServicio;

    @Autowired
    public FleaTreatmentControlador(FleaTreatmentServicio fleaTreatmentService) {
        this.fleaTreatmentServicio = fleaTreatmentService;
    }

    @PostMapping
    public ResponseEntity<FleaTreatment> createFleaTreatment(@RequestBody FleaTreatment fleaTreatment) {
        FleaTreatment createdFleaTreatment = fleaTreatmentServicio.saveFleaTreatment(fleaTreatment);
        return ResponseEntity.ok(createdFleaTreatment);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FleaTreatment> getFleaTreatmentById(@PathVariable Long id) {
        FleaTreatment fleaTreatment = fleaTreatmentServicio.findFleaTreatmentById(id);
        return fleaTreatment != null ? ResponseEntity.ok(fleaTreatment) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<FleaTreatment> getAllFleaTreatments() {
        return fleaTreatmentServicio.findAllFleaTreatments();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFleaTreatment(@PathVariable Long id) {
        fleaTreatmentServicio.deleteFleaTreatment(id);
        return ResponseEntity.noContent().build();
    }
}
