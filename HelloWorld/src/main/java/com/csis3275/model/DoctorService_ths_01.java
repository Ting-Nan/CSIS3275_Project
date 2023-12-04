package com.csis3275.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class DoctorService_ths_01 {
	
	@Autowired
	private DoctorRepository_ths_01 doctorRepository;
	
	
	public Doctor_ths_01 registerDoctor(Doctor_ths_01 new_doctor_ths_01) {
		return doctorRepository.save(new_doctor_ths_01);
	}
	

	@Transactional
	public void deleteDoctorByEmail(String email) {
	    System.out.println("Deleting doctor with email: " + email);
	    Doctor_ths_01 doctor = doctorRepository.findByEmail(email);
	    if (doctor != null) {
	        System.out.println("Found doctor to delete: " + doctor.getEmail());
	        doctorRepository.delete(doctor);
	        System.out.println("Doctor deleted successfully!");
	    } else {
	        System.out.println("Doctor not found with email: " + email);
	    }
	}

	
	
}
