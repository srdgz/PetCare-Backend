package com.petcare_backend.petcare.repositorio;

import com.petcare_backend.petcare.modelo.Deworming;
import com.petcare_backend.petcare.modelo.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DewormingRepositorio extends JpaRepository<Deworming, Long> {
    List<Deworming> findByPet(Pet pet);
}
