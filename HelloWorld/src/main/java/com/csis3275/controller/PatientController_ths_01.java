package com.csis3275.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.csis3275.model.PatientService_ths_01;
import com.csis3275.model.Patient_ths_01;

@Controller
public class PatientController_ths_01 {
	
	@Autowired
	private PatientService_ths_01 patientService;
	
	@GetMapping("/patients/list")
	public String listPatient(Model model) {
		model.addAttribute("patientList",patientService.readPatient());
		return "patients/list";
	}
	
	@GetMapping
	public String deletePatient(@RequestParam("deletepatient")String id) {
		patientService.deletePatient(Long.parseLong(id));
		return "redirect:/patients/list";
		
	}
	
	
		@GetMapping("/patients/add")
		public String addPatient(Model model)	{
			model.addAttribute("addPatient", new Patient_ths_01());
			return "patients/addPatient";
		}
		
		@PostMapping("/patients/add")
		public String addPatient(Patient_ths_01 addPatient)	{
			patientService.createPatient(addPatient);
			return "redirect:/students/list";
		}
		

		
		@GetMapping("/patients/edit")
		public String editPatient(@RequestParam("id") Long id,Model model)	{
			
			model.addAttribute("editPatient", patientService.getPatient(id));
			return "patients/editPatient";
		}

		@PostMapping("/patients/edit")
		public String editPatient(Patient_ths_01 patientToSave)	{
			patientService.updateStudent(patientToSave);
			return "redirect:/patients/list";
		}

}

