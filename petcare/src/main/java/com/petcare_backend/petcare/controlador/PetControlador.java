package com.petcare_backend.petcare.controlador;

import com.petcare_backend.petcare.modelo.Pet;
import com.petcare_backend.petcare.servicio.PetServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
public class PetControlador {

    private final PetServicio petServicio;

    @Autowired
    public PetControlador(PetServicio petService) {
        this.petServicio = petService;
    }

    @PostMapping
    public ResponseEntity<Pet> createPet(@RequestBody Pet pet) {
        Pet createdPet = petServicio.savePet(pet);
        return ResponseEntity.ok(createdPet);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPetById(@PathVariable Long id) {
        Pet pet = petServicio.findPetById(id);
        return pet != null ? ResponseEntity.ok(pet) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<Pet> getAllPets() {
        return petServicio.findAllPets();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable Long id) {
        petServicio.deletePet(id);
        return ResponseEntity.noContent().build();
    }
}
