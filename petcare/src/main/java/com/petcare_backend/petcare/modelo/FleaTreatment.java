package com.petcare_backend.petcare.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "flea_treatments")
@Getter
@Setter
public class FleaTreatment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "treatment_name", nullable = false)
    private String treatmentName;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "periodicity")
    private Integer periodicity;

    @Column(name = "reminder_date")
    private LocalDate reminderDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pet_id", nullable = false)
    private Pet pet;

    // Constructores
    public FleaTreatment() {}

    public FleaTreatment(String treatmentName, LocalDate date, Integer periodicity, LocalDate reminderDate, Pet pet) {
        this.treatmentName = treatmentName;
        this.date = date;
        this.periodicity = periodicity;
        this.reminderDate = reminderDate;
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
