package com.petcare_backend.petcare.repositorio;

import com.petcare_backend.petcare.modelo.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MedicationRepositorio extends JpaRepository<Medication, Long> {
    // Ejemplo de consulta personalizada: encontrar medicaciones por mascota
    List<Medication> findByPetId(Long petId);
}
