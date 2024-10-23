package com.petcare_backend.petcare.servicio;

import com.petcare_backend.petcare.modelo.Medication;
import com.petcare_backend.petcare.modelo.Pet;
import com.petcare_backend.petcare.repositorio.MedicationRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationServicioImpl implements MedicationServicio {

    private final MedicationRepositorio medicationRepositorio;

    @Autowired
    public MedicationServicioImpl(MedicationRepositorio medicationRepository) {
        this.medicationRepositorio = medicationRepository;
    }

    @Override
    public Medication saveMedication(Medication medication) {
        return medicationRepositorio.save(medication);
    }

    @Override
    public Medication findMedicationById(Long id) {
        return medicationRepositorio.findById(id).orElse(null);
    }

    @Override
    public List<Medication> findMedicationsByPet(Pet pet) {
        return medicationRepositorio.findByPet(pet);
    }

    @Override
    public void deleteMedication(Long id) {
        medicationRepositorio.deleteById(id);
    }
}
