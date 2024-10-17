package com.petcare_backend.petcare.servicio;

import com.petcare_backend.petcare.modelo.Medication;
import java.util.List;

public interface MedicationServicio {
    Medication saveMedication(Medication medication);
    Medication findMedicationById(Long id);
    List<Medication> findAllMedications();
    void deleteMedication(Long id);
}
