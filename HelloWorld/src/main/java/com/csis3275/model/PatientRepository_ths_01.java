package com.csis3275.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository_ths_01 extends CrudRepository<Patient_ths_01,Long>{
	
	@Query("SELECT p FROM Patient_ths_01 p WHERE " +
	        "LOWER(p.firstName) LIKE LOWER(:keyword) OR " +
	        "LOWER(p.lastName) LIKE LOWER(:keyword) OR " +
	        "LOWER(p.email) LIKE LOWER(:keyword) OR " +
	        "LOWER(CAST(p.height AS string)) LIKE LOWER(:keyword) OR " +
	        "LOWER(CAST(p.weight AS string)) LIKE LOWER(:keyword)")
	List<Patient_ths_01> search(@Param("keyword") String keyword);
	    
	    @Query("SELECT p FROM Patient_ths_01 p")
	    List<Patient_ths_01> findAll();
}
