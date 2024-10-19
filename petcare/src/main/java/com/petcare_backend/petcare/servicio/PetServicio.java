package com.petcare_backend.petcare.servicio;

import com.petcare_backend.petcare.modelo.Pet;
import com.petcare_backend.petcare.modelo.User;

import java.util.List;

public interface PetServicio {
    Pet savePet(Pet pet);
    Pet findPetById(Long id);
    List<Pet> findAllPets();
    void deletePet(Long id);
    List<Pet> findByOwner(User owner);
}
