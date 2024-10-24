package com.petcare_backend.petcare.controlador;

import com.petcare_backend.petcare.modelo.Pet;
import com.petcare_backend.petcare.modelo.Vaccination;
import com.petcare_backend.petcare.servicio.PetServicio;
import com.petcare_backend.petcare.servicio.VaccinationServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vaccinations")
@CrossOrigin(origins = "http://localhost:4200")
public class VaccinationControlador {

    private final VaccinationServicio vaccinationServicio;
    private final PetServicio petServicio;

    @Autowired
    public VaccinationControlador(VaccinationServicio vaccinationServicio, PetServicio petServicio) {
        this.vaccinationServicio = vaccinationServicio;
        this.petServicio = petServicio;
    }

    @PostMapping
    public ResponseEntity<Vaccination> createVaccination(@RequestBody Vaccination vaccination, @RequestParam Long petId) {
        Pet pet = petServicio.findPetById(petId);
        if (pet == null) {
            return ResponseEntity.badRequest().build();
        }
        vaccination.setPet(pet);
        Vaccination createdVaccination = vaccinationServicio.saveVaccination(vaccination);
        return ResponseEntity.ok(createdVaccination);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vaccination> getVaccinationById(@PathVariable Long id) {
        Vaccination vaccination = vaccinationServicio.findVaccinationById(id);
        return vaccination != null ? ResponseEntity.ok(vaccination) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Vaccination>> getVaccinationsByPet(@RequestParam Long petId) {
        Pet pet = petServicio.findPetById(petId);
        if (pet == null) {
            return ResponseEntity.badRequest().build();
        }
        List<Vaccination> vaccinations = vaccinationServicio.findVaccinationsByPet(pet);
        return ResponseEntity.ok(vaccinations);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVaccination(@PathVariable Long id) {
        vaccinationServicio.deleteVaccination(id);
        return ResponseEntity.noContent().build();
    }
}
