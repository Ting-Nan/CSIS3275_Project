// PatientService_ths_01.java

package com.csis3275.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService_ths_01 {
	
	@Autowired
	private PatientRepository_ths_01 patientRepository;
	
	public Patient_ths_01 createPatient(Patient_ths_01 newPatient) {
		return patientRepository.save(newPatient);
	}
	
	public List<Patient_ths_01> readPatient() {
		return (List<Patient_ths_01>) patientRepository.findAll();
	}
	
	public Patient_ths_01 getPatient(Long id) {
		return patientRepository.findById(id).orElse(new Patient_ths_01());
	}
	
	public void updatePatient(Patient_ths_01 patientToUpdate) {
		Long patientId = patientToUpdate.getId();
		if (patientRepository.existsById(patientId)) {
			patientRepository.save(patientToUpdate);
		} else {
			throw new RuntimeException("Patient with ID " + patientId + " not found");
		}
	}
	
	public void deletePatient(Long idToDelete) {
		patientRepository.deleteById(idToDelete);
	}
	
	
	
	
	public PatientService_ths_01(PatientRepository_ths_01 patientRepository) {
        this.patientRepository = patientRepository;
    }

	
	
	
    
	public List<Patient_ths_01> searchPatients(String keyword) {
        return patientRepository.search(keyword);
    }

	public List<Patient_ths_01> findAll() {
	    return patientRepository.findAll();
	}
}

