package com.csis3275.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService_ths_01 {
	
	@Autowired
	private DoctorRepository_ths_01 doctorRepository;
	
	
	public Doctor_ths_01 registerDoctor(Doctor_ths_01 new_doctor_ths_01) {
		return doctorRepository.save(new_doctor_ths_01);
	}
	

}
