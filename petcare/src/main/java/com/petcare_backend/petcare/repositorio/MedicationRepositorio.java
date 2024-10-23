package com.petcare_backend.petcare.repositorio;

import com.petcare_backend.petcare.modelo.Medication;
import com.petcare_backend.petcare.modelo.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MedicationRepositorio extends JpaRepository<Medication, Long> {
    List<Medication> findByPet(Pet pet);
}
