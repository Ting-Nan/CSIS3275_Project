package com.csis3275.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.csis3275.model.*;
import java.util.List;

@Service
public class PatientService_ths_01 {
	
	@Autowired
	private PatientRepository_ths_01 patientrepository;
	
	
	public Patient_ths_01 createPatient(Patient_ths_01 newPatient) {
		return patientrepository.save(newPatient);
	}
	
	public List<Patient_ths_01> readPatient(){
		return (List<Patient_ths_01>)patientrepository.findAll();
	}
	
	public Patient_ths_01 getPatient(Long id) {
		return patientrepository.findById(id).orElse(new Patient_ths_01());
	}
	
	public void updateStudent(Patient_ths_01 patientToUpdate) {
		Long patientId = patientToUpdate.getId();
		if (patientrepository.existsById(patientId)) {
			
			patientrepository.save(patientToUpdate);
		} else {
			
			throw new RuntimeException("Patient with ID " + patientId + " not found");
		}
	}
	
	public void deletePatient(Long idToDelete) {
		patientrepository.deleteById(idToDelete);
	}

}

