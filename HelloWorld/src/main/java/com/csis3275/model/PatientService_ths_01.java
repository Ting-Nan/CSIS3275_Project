// PatientService_ths_01.java

package com.csis3275.model;

import com.csis3275.model.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
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

	
	//searching function
	public List<Patient_ths_01> searchPatients(String keyword) {
        return patientRepository.search(keyword);
    }

	public List<Patient_ths_01> findAll() {
	    return patientRepository.findAll();
	}
	
	//sorting function
	public List<Patient_ths_01> findAllByOrderByFirstName() {
        return patientRepository.findAllByOrderByFirstNameAsc();
    }

    public List<Patient_ths_01> findAllByOrderByLastName() {
        return patientRepository.findAllByOrderByLastNameAsc();
    }
    
    
    //pagination
 
    
    public Page<Patient_ths_01> listAll(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber - 1, 5);
        return patientRepository.findAll(pageable);
    }

    //Controller test
    public List<Patient_ths_01> getAllPatients() {
        return patientRepository.findAll();
    }
}

