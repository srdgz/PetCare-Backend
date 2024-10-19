package com.petcare_backend.petcare.repositorio;

import com.petcare_backend.petcare.modelo.Pet;
import com.petcare_backend.petcare.modelo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PetRepositorio extends JpaRepository<Pet, Long> {
    // Ejemplo de consulta personalizada: encontrar mascotas por dueño
    List<Pet> findByOwner(User owner);
}
