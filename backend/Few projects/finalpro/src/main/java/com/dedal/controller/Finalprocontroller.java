package com.dedal.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dedal.entity.Doctor;
import com.dedal.entity.Patient;
import com.dedal.service.DoctorInterfaceService;
import com.dedal.service.PatientService;

@RestController
public class Finalprocontroller {
	
	@Autowired
	PatientService patientservice;
	
	@Autowired
	DoctorInterfaceService doctorinterfaceservice;
	
	@GetMapping("/a")
	public String hello() {
		return "Hello patient";
	}
	
	@PostMapping("/addPatient")
	public Patient addPatient(@RequestBody Patient patient) {
		return patientservice.addPatient(patient);
	}
	public List<Patient> listAllPatient(){
		return patientservice.listAllPatient();
	}
	@PostMapping("/addDoctor")
	public Doctor addDoctor(@RequestBody Doctor doctor) {
		return doctorinterfaceservice.addDoctor(doctor);
		
	}
	public List<Doctor> listAllDoctor(){
		return doctorinterfaceservice.listAllDoctor();
		
	}
	

}
