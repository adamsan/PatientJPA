package com.codecool.jpa.medicinejpa.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(min = 5)
    private String name;

    @OneToMany(mappedBy = "doctor")
    @JsonBackReference
    private List<Patient> patients;

    @Enumerated(EnumType.STRING)
    private DoctorType doctorType;
}
