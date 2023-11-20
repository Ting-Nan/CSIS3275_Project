<<<<<<< HEAD
// PatientService_ths_01.java

=======
>>>>>>> modelbranch_ths_01
package com.csis3275.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
<<<<<<< HEAD

=======
import com.csis3275.model.*;
>>>>>>> modelbranch_ths_01
import java.util.List;

@Service
public class PatientService_ths_01 {
	
	@Autowired
<<<<<<< HEAD
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
=======
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
			
>>>>>>> modelbranch_ths_01
			throw new RuntimeException("Patient with ID " + patientId + " not found");
		}
	}
	
	public void deletePatient(Long idToDelete) {
<<<<<<< HEAD
		patientRepository.deleteById(idToDelete);
	}
=======
		patientrepository.deleteById(idToDelete);
	}

>>>>>>> modelbranch_ths_01
}

