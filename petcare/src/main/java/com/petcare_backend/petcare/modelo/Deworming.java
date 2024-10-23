package com.petcare_backend.petcare.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "dewormings")
@Getter
@Setter
public class Deworming {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "deworming_name", nullable = false)
    private String dewormingName;

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
    public Deworming() {}

    public Deworming(String dewormingName, LocalDate date, Integer periodicity, LocalDate reminderDate, Pet pet) {
        this.dewormingName = dewormingName;
        this.date = date;
        this.periodicity = periodicity;
        this.reminderDate = reminderDate;
        this.pet = pet;
    }

    // Método toString
    @Override
    public String toString() {
        return "Deworming{" +
                "id=" + id +
                ", dewormingName='" + dewormingName + '\'' +
                ", date=" + date +
                ", pet=" + (pet != null ? pet.getName() : "N/A") +
                '}';
    }

    // Métodos equals y hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deworming that = (Deworming) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(dewormingName, that.dewormingName) &&
                Objects.equals(date, that.date) &&
                Objects.equals(pet, that.pet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dewormingName, date, pet);
    }
}
