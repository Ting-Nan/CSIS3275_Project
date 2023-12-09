package com.csis3275.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="patient")
public class Patient_ths_01 {
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private double height;
	private double weight;
	//private String symptoms;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
	private List<String> symptoms;
	private String prescribe;

	private String keyword;
	
	public Patient_ths_01(Long id, String firstName, String lastName, String email, double height, double weight,
			LocalDate dob, List<String> symptoms, String prescribe, String keyword) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.height = height;
		this.weight = weight;
		this.dob = dob;
		this.symptoms = symptoms;
		this.prescribe = prescribe;
		this.keyword = keyword;
	}

	



	public Patient_ths_01(Long id, String firstName, String lastName, String email, double height, double weight,
			List<String> symptoms, String prescribe) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.height = height;
		this.weight = weight;
		this.symptoms = symptoms;
		this.prescribe = prescribe;
	}





	public String getKeyword() {
		return keyword;
	}


	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}




	public Patient_ths_01() {
		
	}
	

	public List<String> getSymptoms() {
		return symptoms;
	}
	public void setSymptoms(List<String> symptoms) {
		this.symptoms = symptoms;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getPrescribe() {
		return prescribe;
	}
	public void setPrescribe(String prescribe) {
		this.prescribe = prescribe;
	}
	
	

}

