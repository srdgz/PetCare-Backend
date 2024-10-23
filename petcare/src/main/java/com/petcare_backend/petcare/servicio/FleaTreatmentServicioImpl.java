package com.petcare_backend.petcare.servicio;

import com.petcare_backend.petcare.modelo.FleaTreatment;
import com.petcare_backend.petcare.modelo.Pet;
import com.petcare_backend.petcare.repositorio.FleaTreatmentRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FleaTreatmentServicioImpl implements FleaTreatmentServicio {

    private final FleaTreatmentRepositorio fleaTreatmentRepositorio;

    @Autowired
    public FleaTreatmentServicioImpl(FleaTreatmentRepositorio fleaTreatmentRepository) {
        this.fleaTreatmentRepositorio = fleaTreatmentRepository;
    }

    @Override
    public FleaTreatment saveFleaTreatment(FleaTreatment fleaTreatment) {
        return fleaTreatmentRepositorio.save(fleaTreatment);
    }

    @Override
    public FleaTreatment findFleaTreatmentById(Long id) {
        return fleaTreatmentRepositorio.findById(id).orElse(null);
    }

    @Override
    public List<FleaTreatment> findFleaTreatmentsByPet(Pet pet) {
        return fleaTreatmentRepositorio.findByPet(pet);
    }

    @Override
    public void deleteFleaTreatment(Long id) {
        fleaTreatmentRepositorio.deleteById(id);
    }
}
