package com.codecool.jpa.medicinejpa.controller;

import com.codecool.jpa.medicinejpa.model.Patient;
import com.codecool.jpa.medicinejpa.repository.PatientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {
    @Autowired
    private PatientDao patientDao;

    @GetMapping("/patients")
    public List<Patient> getPatients() {
        return patientDao.findAll();
    }

    @PostMapping("/patient")
    public void addNewPatient(@RequestBody Patient patient) {
        System.out.println(patient);
        patientDao.save(patient);
    }

    @GetMapping(value = "/patients", params = {"name"})
    public List<Patient> findPatientsByName(@RequestParam("name") String nameStart){
        return patientDao.findAllByNameStartsWith(nameStart);
    }
}
