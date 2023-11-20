package com.csis3275.controller;

import com.csis3275.model.Doctor_ths_01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.csis3275.model.DoctorRepository_ths_01;
import com.csis3275.model.DoctorService_ths_01;

@Controller
public class DoctorController_ths_01 {
	
	@Autowired
	private DoctorService_ths_01 doctorService_ths_01;
	private DoctorRepository_ths_01 doctorRepository_ths_01;
	
	@GetMapping("/doctor/register")
	public String registerDoctor(Model model) {
		model.addAttribute("register", new Doctor_ths_01());
		return "doctor/login";
	}
	
	@GetMapping("/doctor/login")
	public String loginDoctor(Model model) {
		model.addAttribute("login", new Doctor_ths_01());
		return "doctor/login";
	}
	
	@PostMapping("/doctor/register")
	public String registerDoctor(Doctor_ths_01 registerDoctor) {
		doctorService_ths_01.registerDoctor(registerDoctor);
		return "redirect:/doctor/login";
	}
	
	@PostMapping("/doctor/login")
	public String loginDoctor(@RequestBody Doctor_ths_01 doctor_ths_01) {
		Doctor_ths_01 storedDoctor = doctorRepository_ths_01.findByEmail(doctor_ths_01.getEmail());
		
		if (storedDoctor != null && storedDoctor.getPassword().equals(doctor_ths_01.getPassword())) {
			return "redirect:/patients/list";
		} else {
			return "User logged in fail";
		}
	}
	
	

}
