package com.petcare_backend.petcare.modelo;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "flea_treatments")
public class FleaTreatment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "treatment_name", nullable = false)
    private String treatmentName;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pet_id")
    private Pet pet;

    // Constructores
    public FleaTreatment() {}

    public FleaTreatment(String treatmentName, LocalDate date, Pet pet) {
        this.treatmentName = treatmentName;
        this.date = date;
        this.pet = pet;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTreatmentName() {
        return treatmentName;
    }

    public void setTreatmentName(String treatmentName) {
        this.treatmentName = treatmentName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    // Método toString
    @Override
    public String toString() {
        return "FleaTreatment{" +
                "id=" + id +
                ", treatmentName='" + treatmentName + '\'' +
                ", date=" + date +
                ", pet=" + (pet != null ? pet.getName() : "N/A") +
                '}';
    }

    // Métodos equals y hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FleaTreatment that = (FleaTreatment) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(treatmentName, that.treatmentName) &&
                Objects.equals(date, that.date) &&
                Objects.equals(pet, that.pet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, treatmentName, date, pet);
    }
}
