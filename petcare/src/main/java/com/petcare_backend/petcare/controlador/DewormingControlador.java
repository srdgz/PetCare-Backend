package com.petcare_backend.petcare.controlador;

import com.petcare_backend.petcare.modelo.Deworming;
import com.petcare_backend.petcare.modelo.Pet;
import com.petcare_backend.petcare.servicio.DewormingServicio;
import com.petcare_backend.petcare.servicio.PetServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dewormings")
@CrossOrigin(origins = "http://localhost:4200")
public class DewormingControlador {

    private final DewormingServicio dewormingServicio;
    private final PetServicio petServicio;

    @Autowired
    public DewormingControlador(DewormingServicio dewormingServicio, PetServicio petServicio) {
        this.dewormingServicio = dewormingServicio;
        this.petServicio = petServicio;
    }

    @PostMapping
    public ResponseEntity<Deworming> createDeworming(@RequestBody Deworming deworming, @RequestParam Long petId) {
        Pet pet = petServicio.findPetById(petId);
        if (pet == null) {
            return ResponseEntity.badRequest().build();
        }
        deworming.setPet(pet);
        Deworming createdDeworming = dewormingServicio.saveDeworming(deworming);
        return ResponseEntity.ok(createdDeworming);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Deworming> getDewormingById(@PathVariable Long id) {
        Deworming deworming = dewormingServicio.findDewormingById(id);
        return deworming != null ? ResponseEntity.ok(deworming) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Deworming>> getDewormingsByPet(@RequestParam Long petId) {
        Pet pet = petServicio.findPetById(petId);
        if (pet == null) {
            return ResponseEntity.badRequest().build();
        }
        List<Deworming> dewormings = dewormingServicio.findDewormingsByPet(pet);
        return ResponseEntity.ok(dewormings);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDeworming(@PathVariable Long id) {
        dewormingServicio.deleteDeworming(id);
        return ResponseEntity.noContent().build();
    }
}
