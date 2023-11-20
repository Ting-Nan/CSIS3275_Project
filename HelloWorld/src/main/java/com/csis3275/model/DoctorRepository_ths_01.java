package com.csis3275.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository_ths_01 extends CrudRepository<Doctor_ths_01,Long>{
	Doctor_ths_01 findByEmail(String email);
}
