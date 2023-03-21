package com.codecool.jpa.medicinejpa.controller;

import com.codecool.jpa.medicinejpa.model.Doctor;
import com.codecool.jpa.medicinejpa.model.DoctorType;
import com.codecool.jpa.medicinejpa.repository.DoctorDao;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DoctorController {
    private final DoctorDao doctorDao;

    public DoctorController(DoctorDao doctorDao) {
        this.doctorDao = doctorDao;
    }

    @GetMapping("/doctors")
    @ResponseBody
    public List<Doctor> findAll() {
        return doctorDao.findAll();
    }

    @GetMapping("/doctor")
    public String index(Model model) {
        model.addAttribute("doctors", doctorDao.findAll());
        Doctor newDoctor = new Doctor(null, "", null, DoctorType.MEDICAL);
        model.addAttribute("doctor", newDoctor);
        return "index";
    }

    @PostMapping("/doctor")
    public String saveNewDoctor(
            @Valid Doctor doctor,
            BindingResult errors,
            Model model
    ) {
        if (errors.hasErrors()) {
            System.out.println("Wrong doctor!");
            model.addAttribute("doctor", doctor);
            model.addAttribute("doctors", doctorDao.findAll());
            return "index";
        } else {
            doctor = doctorDao.save(doctor);
            System.out.println("New doctor:");
            System.out.println(doctor);
            return "redirect:doctor";
        }

    }
}
