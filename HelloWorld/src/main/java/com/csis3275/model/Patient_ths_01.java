package com.csis3275.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="patient")
public class Patient_ths_01 {
	
	
<<<<<<< HEAD
	
=======
>>>>>>> modelbranch_ths_01
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private double height;
	private double weight;
<<<<<<< HEAD
	private String symptoms;
=======
>>>>>>> modelbranch_ths_01
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
	
	public Patient_ths_01() {
		
	}
	
<<<<<<< HEAD



	public Patient_ths_01(Long id, String firstName, String lastName, String email, double height, double weight,
			String symptoms, LocalDate dob) {
=======
	
	
	public Patient_ths_01(Long id, String firstName, String lastName, String email, double height, double weight,
			LocalDate dob) {
>>>>>>> modelbranch_ths_01
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.height = height;
		this.weight = weight;
<<<<<<< HEAD
		this.symptoms = symptoms;
=======
>>>>>>> modelbranch_ths_01
		this.dob = dob;
	}



<<<<<<< HEAD
	public String getSymptoms() {
		return symptoms;
	}
	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

=======
>>>>>>> modelbranch_ths_01
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
	
	

}
<<<<<<< HEAD

=======
>>>>>>> modelbranch_ths_01
