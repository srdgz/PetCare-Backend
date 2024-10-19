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
    public PetServicioImpl(PetRepositorio petRepository) {
        this.petRepositorio = petRepository;
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
    public List<Pet> findAllPets() {
        return petRepositorio.findAll();
    }

    @Override
    public void deletePet(Long id) {
        petRepositorio.deleteById(id);
    }

    @Override
    public List<Pet> findByOwner(User owner) {
        return petRepositorio.findByOwner(owner);
    }
}

