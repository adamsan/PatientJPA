package com.codecool.jpa.medicinejpa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @JsonProperty("date_of_birth")
    @Column(name = "szuletett")
    private LocalDate dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    @JsonIgnore // other solution: https://www.baeldung.com/jackson-bidirectional-relationships-and-infinite-recursion
    private Doctor doctor;
}
