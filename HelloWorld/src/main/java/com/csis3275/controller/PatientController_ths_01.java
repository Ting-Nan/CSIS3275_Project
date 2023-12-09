package com.csis3275.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.csis3275.model.PatientRepository_ths_01;
import com.csis3275.model.PatientService_ths_01;
import com.csis3275.model.Patient_ths_01;
import com.csis3275.model.SymptomService_ths_01;

//@RestController
@Controller
public class PatientController_ths_01 {

    private final PatientService_ths_01 patientService;
    private final SymptomService_ths_01 symptomService;
    
    @Autowired
    private PatientRepository_ths_01 patientRepository;

 

    @Autowired
    public PatientController_ths_01(PatientService_ths_01 patientService, SymptomService_ths_01 symptomService) {
        this.patientService = patientService;
        this.symptomService = symptomService;
    }

    @GetMapping("/patients/list")
    public String listPatient(Model model) {
        model.addAttribute("patientList", patientService.readPatient());
        return "patients/list";
    }

    @GetMapping("/patients/delete")
    public String deletePatient(@RequestParam("id") String id) {
        if (id == null || id.isEmpty()) {
            return "redirect:/patients/list";
        }
        patientService.deletePatient(Long.parseLong(id));
        return "redirect:/patients/list";
    }

    @GetMapping("/patients/add")
    public String addPatient(Model model) {
        model.addAttribute("addPatient", new Patient_ths_01());
        return "patients/addPatient";
    }

    @PostMapping("/patients/add")
    public String addPatient(Patient_ths_01 addPatient) {
        patientService.createPatient(addPatient);
        return "redirect:/patients/list";
    }

    @GetMapping("/patients/edit")
    public String editPatient(@RequestParam("id") Long id, Model model) {
        Patient_ths_01 originalPatient = patientService.getPatient(id);
        model.addAttribute("editPatient", originalPatient);

        
        List<String> allSymptoms = symptomService.getAllSymptoms();
        model.addAttribute("allSymptoms", allSymptoms);

        return "patients/editPatient";
    }

    @PostMapping("/patients/edit")
    public String editPatient(@ModelAttribute("editPatient") Patient_ths_01 editedPatient) {
        patientService.updatePatient(editedPatient);
        return "redirect:/patients/list";
    }
    
    @GetMapping("/patients/prescribe")
    public String prescribePatient(@RequestParam("id") Long id, Model model) {
        Patient_ths_01 originalPatient = patientService.getPatient(id);
        model.addAttribute("prescribePatient", originalPatient);    

        
        return "patients/prescribePatient";
    }
    
    @PostMapping("/patients/prescribe")
    public String prescribePatient(@ModelAttribute("prescribePatient") Patient_ths_01 prescribePatient) {
        try {
            patientService.updatePatient(prescribePatient);
         
            return "redirect:/patients/list";
        } catch (Exception e) {
            e.printStackTrace(); 
            return "redirect:/patients/list"; 
        }
    }
    
    @GetMapping("/patients/setup-appointment")
    public String setupAppointment(Model model) {
        return "patients/setupAppointment";
    }
    
    
    //search function
    @RequestMapping("/patients/list/search")
    public String patientList(Model model, @RequestParam(name = "keyword", required = false) String keyword) {
        List<Patient_ths_01> patientList;

        if (keyword != null && !keyword.isEmpty()) {
            patientList = patientService.searchPatients(keyword);
        } else {
            patientList = patientService.findAll(); 
        }

        model.addAttribute("patientList", patientList);
        model.addAttribute("keyword", keyword);

        return "patients/list";
    }
    
    
    //sorting function
    @GetMapping("/patients/list/sort")
    public String sortPatients(Model model, @RequestParam(name = "sortBy", required = false) String sortBy) {
        List<Patient_ths_01> patientList;

        if ("firstName".equals(sortBy)) {
            patientList = patientService.findAllByOrderByFirstName();
        } else if ("lastName".equals(sortBy)) {
            patientList = patientService.findAllByOrderByLastName();
        } else {
            
            patientList = patientService.findAll();
        }

        model.addAttribute("patientList", patientList);
        model.addAttribute("sortBy", sortBy);

        return "patients/list";
    }
    
    @GetMapping("/patients/list/default")
    public String defaultSortPatients(Model model) {
        List<Patient_ths_01> patientList = patientService.findAll();
        model.addAttribute("patientList", patientList);
        model.addAttribute("sortBy", "default"); 
        return "patients/list";
    }
    
    
    //pagination
    @RequestMapping("/")
    public String viewlist(Model model) {
    	return listByPage(model, 1);
    }
     
    
    @GetMapping("/page/{pageNumber}")
    public String listByPage(Model model, @PathVariable("pageNumber") int currentPage) {
        Page<Patient_ths_01> patientPage = patientService.listAll(currentPage);
        long totalItems = patientPage.getTotalElements();
        List<Patient_ths_01> patients = patientPage.getContent();
        int totalPages = patientPage.getTotalPages();

        model.addAttribute("patientList", patients);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("totalPages", totalPages);
        
        return "patients/list";
    }



    
 

}

