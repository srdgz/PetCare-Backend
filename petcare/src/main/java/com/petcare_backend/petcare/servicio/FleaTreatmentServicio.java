package com.petcare_backend.petcare.servicio;

import com.petcare_backend.petcare.modelo.FleaTreatment;
import com.petcare_backend.petcare.modelo.Pet;

import java.util.List;

public interface FleaTreatmentServicio {
    FleaTreatment saveFleaTreatment(FleaTreatment fleaTreatment);
    FleaTreatment findFleaTreatmentById(Long id);
    List<FleaTreatment> findFleaTreatmentsByPet(Pet pet);
    void deleteFleaTreatment(Long id);
}
