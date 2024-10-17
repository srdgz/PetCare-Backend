package com.petcare_backend.petcare.servicio;

import com.petcare_backend.petcare.modelo.Vaccination;
import com.petcare_backend.petcare.repositorio.VaccinationRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccinationServicioImpl implements VaccinationServicio {

    private final VaccinationRepositorio vaccinationRepositorio;

    @Autowired
    public VaccinationServicioImpl(VaccinationRepositorio vaccinationRepository) {
        this.vaccinationRepositorio = vaccinationRepository;
    }

    @Override
    public Vaccination saveVaccination(Vaccination vaccination) {
        return vaccinationRepositorio.save(vaccination);
    }

    @Override
    public Vaccination findVaccinationById(Long id) {
        return vaccinationRepositorio.findById(id).orElse(null);
    }

    @Override
    public List<Vaccination> findAllVaccinations() {
        return vaccinationRepositorio.findAll();
    }

    @Override
    public void deleteVaccination(Long id) {
        vaccinationRepositorio.deleteById(id);
    }
}
