package com.petcare_backend.petcare.controlador;

import com.petcare_backend.petcare.modelo.Vaccination;
import com.petcare_backend.petcare.servicio.VaccinationServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vaccinations")
public class VaccinationControlador {

    private final VaccinationServicio vaccinationServicio;

    @Autowired
    public VaccinationControlador(VaccinationServicio vaccinationService) {
        this.vaccinationServicio = vaccinationService;
    }

    @PostMapping
    public ResponseEntity<Vaccination> createVaccination(@RequestBody Vaccination vaccination) {
        Vaccination createdVaccination = vaccinationServicio.saveVaccination(vaccination);
        return ResponseEntity.ok(createdVaccination);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vaccination> getVaccinationById(@PathVariable Long id) {
        Vaccination vaccination = vaccinationServicio.findVaccinationById(id);
        return vaccination != null ? ResponseEntity.ok(vaccination) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<Vaccination> getAllVaccinations() {
        return vaccinationServicio.findAllVaccinations();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVaccination(@PathVariable Long id) {
        vaccinationServicio.deleteVaccination(id);
        return ResponseEntity.noContent().build();
    }
}
