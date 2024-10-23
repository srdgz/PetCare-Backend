package com.petcare_backend.petcare.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "medications")
@Getter
@Setter
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "medication_name", nullable = false)
    private String medicationName;

    @Column(name = "dosage")
    private String dosage;

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
    public Medication() {}

    public Medication(String medicationName, String dosage, LocalDate date, Integer periodicity, LocalDate reminderDate, Pet pet) {
        this.medicationName = medicationName;
        this.dosage = dosage;
        this.date = date;
        this.periodicity = periodicity;
        this.reminderDate = reminderDate;
        this.pet = pet;
    }

    // Método toString
    @Override
    public String toString() {
        return "Medication{" +
                "id=" + id +
                ", medicationName='" + medicationName + '\'' +
                ", dosage='" + dosage + '\'' +
                ", date=" + date +
                ", pet=" + (pet != null ? pet.getName() : "N/A") +
                '}';
    }

    // Métodos equals y hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medication that = (Medication) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(medicationName, that.medicationName) &&
                Objects.equals(dosage, that.dosage) &&
                Objects.equals(date, that.date) &&
                Objects.equals(pet, that.pet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, medicationName, dosage, date, pet);
    }
}
