package com.petcare_backend.petcare.repositorio;

import com.petcare_backend.petcare.modelo.Deworming;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DewormingRepositorio extends JpaRepository<Deworming, Long> {
    // Ejemplo de consulta personalizada: encontrar desparasitaciones por mascota
    List<Deworming> findByPetId(Long petId);
}
