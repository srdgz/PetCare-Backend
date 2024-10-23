package com.petcare_backend.petcare.servicio;

import com.petcare_backend.petcare.modelo.Pet;
import com.petcare_backend.petcare.modelo.User;
import com.petcare_backend.petcare.repositorio.PetRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServicioImpl implements PetServicio {

    private final PetRepositorio petRepositorio;

    @Autowired
    public PetServicioImpl(PetRepositorio petRepositorio) {
        this.petRepositorio = petRepositorio;
    }

    @Override
    public Pet savePet(Pet pet) {
        return petRepositorio.save(pet);
    }

    @Override
    public Pet findPetById(Long id) {
        return petRepositorio.findById(id).orElse(null);
    }

    @Override
    public List<Pet> findPetsByOwner(User owner) {
        return petRepositorio.findPetsByOwner(owner);
    }

    @Override
    public void deletePet(Long id) {
        petRepositorio.deleteById(id);
    }

    public Pet updatePet(Long id, Pet petDetails) {
        Pet existingPet = findPetById(id);
        if (existingPet != null) {
            if (petDetails.getName() != null) {
                existingPet.setName(petDetails.getName());
            }
            if (petDetails.getSpecies() != null) {
                existingPet.setSpecies(petDetails.getSpecies());
            }
            if (petDetails.getBreed() != null) {
                existingPet.setBreed(petDetails.getBreed());
            }
            return petRepositorio.save(existingPet);
        }
        return null;
    }

}

