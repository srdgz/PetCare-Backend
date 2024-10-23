package com.petcare_backend.petcare.repositorio;

import com.petcare_backend.petcare.modelo.FleaTreatment;
import com.petcare_backend.petcare.modelo.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FleaTreatmentRepositorio extends JpaRepository<FleaTreatment, Long> {
    List<FleaTreatment> findByPet(Pet pet);
}
