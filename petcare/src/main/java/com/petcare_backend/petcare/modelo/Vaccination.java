package com.petcare_backend.petcare.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "vaccinations")
@Getter
@Setter
public class Vaccination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vaccine_name", nullable = false)
    private String vaccineName;

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
    public Vaccination() {}

    public Vaccination(String vaccineName, LocalDate date, Integer periodicity, LocalDate reminderDate, Pet pet) {
        this.vaccineName = vaccineName;
        this.date = date;
        this.periodicity = periodicity;
        this.reminderDate = reminderDate;
        this.pet = pet;
    }

    // Método toString
    @Override
    public String toString() {
        return "Vaccination{" +
                "id=" + id +
                ", vaccineName='" + vaccineName + '\'' +
                ", date=" + date +
                ", pet=" + (pet != null ? pet.getName() : "N/A") +
                '}';
    }

    // Métodos equals y hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vaccination that = (Vaccination) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(vaccineName, that.vaccineName) &&
                Objects.equals(date, that.date) &&
                Objects.equals(periodicity, that.periodicity) &&
                Objects.equals(reminderDate, that.reminderDate) &&
                Objects.equals(pet, that.pet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vaccineName, date, periodicity, reminderDate, pet);
    }
}