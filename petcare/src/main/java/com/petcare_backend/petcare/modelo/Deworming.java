package com.petcare_backend.petcare.modelo;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "dewormings")
public class Deworming {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "deworming_name", nullable = false)
    private String dewormingName;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pet_id")
    private Pet pet;

    // Constructores
    public Deworming() {}

    public Deworming(String dewormingName, LocalDate date, Pet pet) {
        this.dewormingName = dewormingName;
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

    public String getDewormingName() {
        return dewormingName;
    }

    public void setDewormingName(String dewormingName) {
        this.dewormingName = dewormingName;
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
