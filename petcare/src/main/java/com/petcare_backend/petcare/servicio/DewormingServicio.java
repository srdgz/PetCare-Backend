package com.petcare_backend.petcare.servicio;

import com.petcare_backend.petcare.modelo.Deworming;
import java.util.List;

public interface DewormingServicio {
    Deworming saveDeworming(Deworming deworming);
    Deworming findDewormingById(Long id);
    List<Deworming> findAllDewormings();
    void deleteDeworming(Long id);
}
