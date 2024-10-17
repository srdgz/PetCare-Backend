package com.petcare_backend.petcare.repositorio;

import com.petcare_backend.petcare.modelo.Vaccination;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VaccinationRepositorio extends JpaRepository<Vaccination, Long> {
    // Ejemplo de consulta personalizada: encontrar vacunaciones por mascota
    List<Vaccination> findByPetId(Long petId);
}
