package com.petcare_backend.petcare.servicio;

import com.petcare_backend.petcare.modelo.Deworming;
import com.petcare_backend.petcare.modelo.Pet;
import com.petcare_backend.petcare.repositorio.DewormingRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DewormingServicioImpl implements DewormingServicio {

    private final DewormingRepositorio dewormingRepositorio;

    @Autowired
    public DewormingServicioImpl(DewormingRepositorio dewormingRepositorio) {
        this.dewormingRepositorio = dewormingRepositorio;
    }

    @Override
    public Deworming saveDeworming(Deworming deworming) {
        return dewormingRepositorio.save(deworming);
    }

    @Override
    public Deworming findDewormingById(Long id) {
        return dewormingRepositorio.findById(id).orElse(null);
    }

    @Override
    public List<Deworming> findDewormingsByPet(Pet pet) {
        return dewormingRepositorio.findByPet(pet);
    }

    @Override
    public void deleteDeworming(Long id) {
        dewormingRepositorio.deleteById(id);
    }
}
