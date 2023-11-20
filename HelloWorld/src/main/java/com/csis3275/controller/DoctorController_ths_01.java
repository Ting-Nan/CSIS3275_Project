controllerBranch_ths_01
package com.csis3275.controller;

import com.csis3275.model.Doctor_ths_01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.csis3275.model.DoctorRepository_ths_01;
import com.csis3275.model.DoctorService_ths_01;

@Controller
public class DoctorController_ths_01 {
	
	private final DoctorService_ths_01 doctorService_ths_01;
    private final DoctorRepository_ths_01 doctorRepository_ths_01;

    @Autowired
    public DoctorController_ths_01(DoctorService_ths_01 doctorService_ths_01, DoctorRepository_ths_01 doctorRepository_ths_01) {
        this.doctorService_ths_01 = doctorService_ths_01;
        this.doctorRepository_ths_01 = doctorRepository_ths_01;
    }
	
	@GetMapping("/doctor/register")
	public String registerDoctor(Model model) {
		model.addAttribute("register", new Doctor_ths_01());
		return "doctor/register";
	}
	
	@GetMapping("/doctor/login")
	public String loginDoctor(Model model) {
		model.addAttribute("login", new Doctor_ths_01());
		return "doctor/login";
	}
	
	@PostMapping("/doctor/register")
	public String registerDoctor(@Validated @ModelAttribute("register") Doctor_ths_01 registerDoctor, BindingResult result) {
		if (result.hasErrors()) {
	        // If there are validation errors, handle them (e.g., return to the registration form with error messages)
	        return "doctor/register";
	    }
		
		doctorService_ths_01.registerDoctor(registerDoctor);
		return "redirect:/doctor/login";
	}
	
	@PostMapping("/doctor/login")
	public String loginDoctor(@RequestParam String email, @RequestParam String password, Model model) {
		Doctor_ths_01 storedDoctor = doctorRepository_ths_01.findByEmail(email);
		
		if (storedDoctor != null && storedDoctor.getPassword().equals(password)) {
			return "redirect:/patients/list";
		} else {
			return "redirect:/doctor/login";
		}
	}
	
	

}
