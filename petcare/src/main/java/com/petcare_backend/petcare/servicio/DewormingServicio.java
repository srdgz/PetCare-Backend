package com.petcare_backend.petcare.servicio;

import com.petcare_backend.petcare.modelo.Deworming;
import com.petcare_backend.petcare.modelo.Pet;

import java.util.List;

public interface DewormingServicio {
    Deworming saveDeworming(Deworming deworming);
    Deworming findDewormingById(Long id);
    List<Deworming> findDewormingsByPet(Pet pet);
    void deleteDeworming(Long id);
}
