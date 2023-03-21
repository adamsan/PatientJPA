package com.codecool.jpa.medicinejpa.repository;

import com.codecool.jpa.medicinejpa.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientDao extends JpaRepository<Patient, Integer> {

    @Query(value = "select id, name, szuletett from patient where name like :nameStart%", nativeQuery = true)
    List<Patient> findAllByNameStartsWith(String nameStart);
}
