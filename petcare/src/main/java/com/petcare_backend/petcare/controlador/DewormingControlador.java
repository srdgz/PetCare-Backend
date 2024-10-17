package com.petcare_backend.petcare.controlador;

import com.petcare_backend.petcare.modelo.Deworming;
import com.petcare_backend.petcare.servicio.DewormingServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dewormings")
public class DewormingControlador {

    private final DewormingServicio dewormingServicio;

    @Autowired
    public DewormingControlador(DewormingServicio dewormingServicio) {
        this.dewormingServicio = dewormingServicio;
    }

    @PostMapping
    public ResponseEntity<Deworming> createDeworming(@RequestBody Deworming deworming) {
        Deworming createdDeworming = dewormingServicio.saveDeworming(deworming);
        return ResponseEntity.ok(createdDeworming);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Deworming> getDewormingById(@PathVariable Long id) {
        Deworming deworming = dewormingServicio.findDewormingById(id);
        return deworming != null ? ResponseEntity.ok(deworming) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<Deworming> getAllDewormings() {
        return dewormingServicio.findAllDewormings();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDeworming(@PathVariable Long id) {
        dewormingServicio.deleteDeworming(id);
        return ResponseEntity.noContent().build();
    }
}
