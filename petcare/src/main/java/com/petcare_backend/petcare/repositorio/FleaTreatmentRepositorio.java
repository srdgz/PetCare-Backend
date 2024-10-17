package com.petcare_backend.petcare.repositorio;

import com.petcare_backend.petcare.modelo.FleaTreatment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FleaTreatmentRepositorio extends JpaRepository<FleaTreatment, Long> {
    // Ejemplo de consulta personalizada: encontrar tratamientos antipulgas por mascota
    List<FleaTreatment> findByPetId(Long petId);
}
