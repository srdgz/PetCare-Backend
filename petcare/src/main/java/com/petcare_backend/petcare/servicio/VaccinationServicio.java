package com.petcare_backend.petcare.servicio;

import com.petcare_backend.petcare.modelo.Pet;
import com.petcare_backend.petcare.modelo.Vaccination;
import java.util.List;

public interface VaccinationServicio {
    Vaccination saveVaccination(Vaccination vaccination);
    Vaccination findVaccinationById(Long id);
    List<Vaccination> findVaccinationsByPet(Pet pet);
    void deleteVaccination(Long id);
}
