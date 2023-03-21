package com.codecool.jpa.medicinejpa.controller;

import com.codecool.jpa.medicinejpa.model.Doctor;
import com.codecool.jpa.medicinejpa.repository.DoctorDao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DoctorController {
    private final DoctorDao doctorDao;

    public DoctorController(DoctorDao doctorDao) {
        this.doctorDao = doctorDao;
    }

    @GetMapping("/doctors")
    public List<Doctor> findAll() {
        return doctorDao.findAll();
    }
}
