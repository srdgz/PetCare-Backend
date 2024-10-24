package com.petcare_backend.petcare.controlador;

import com.petcare_backend.petcare.modelo.Pet;
import com.petcare_backend.petcare.modelo.User;
import com.petcare_backend.petcare.servicio.PetServicio;
import com.petcare_backend.petcare.servicio.UserServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/pets")
@CrossOrigin(origins = "http://localhost:4200")
public class PetControlador {

    private final PetServicio petServicio;
    private final UserServicio userServicio;

    @Autowired
    public PetControlador(PetServicio petService, UserServicio userServicio) {
        this.petServicio = petService;
        this.userServicio = userServicio;
    }

    @PostMapping
    public ResponseEntity<Pet> createPet(@RequestBody Pet pet, Principal principal) {
        User owner = userServicio.findUserByUsername(principal.getName());
        if (owner == null) {
            return ResponseEntity.badRequest().build();
        }
        pet.setOwner(owner);
        Pet createdPet = petServicio.savePet(pet);
        return ResponseEntity.ok(createdPet);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPetById(@PathVariable Long id, Principal principal) {
        User owner = userServicio.findUserByUsername(principal.getName());
        Pet pet = petServicio.findPetById(id);
        if (pet != null && pet.getOwner().equals(owner)) {
            return ResponseEntity.ok(pet);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Pet>> getAllPetsByUser(Principal principal) {
        User owner = userServicio.findUserByUsername(principal.getName());
        if (owner == null) {
            return ResponseEntity.badRequest().build();
        }
        List<Pet> pets = petServicio.findPetsByOwner(owner);
        return ResponseEntity.ok(pets);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pet> updatePet(@PathVariable Long id, @RequestBody Pet petDetails, Principal principal) {
        User owner = userServicio.findUserByUsername(principal.getName());
        Pet pet = petServicio.findPetById(id);
        if (pet != null && pet.getOwner().equals(owner)) {
            Pet updatedPet = petServicio.updatePet(id, petDetails);
            return ResponseEntity.ok(updatedPet);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable Long id, Principal principal) {
        User owner = userServicio.findUserByUsername(principal.getName());
        Pet pet = petServicio.findPetById(id);
        if (pet != null && pet.getOwner().equals(owner)) {
            petServicio.deletePet(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
