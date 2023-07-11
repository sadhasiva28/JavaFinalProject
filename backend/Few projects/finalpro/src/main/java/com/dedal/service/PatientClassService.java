package com.dedal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dedal.entity.Patient;
import com.dedal.repository.Patientrepository;

@Service
public class PatientClassService implements PatientService{

	@Autowired
	Patientrepository patientrepository;
	
	@Override
	public Patient addPatient(Patient patient) {
		
		return patientrepository.save(patient);
	}

	@Override
	public List<Patient> listAllPatient() {
		
		return (List<Patient>) patientrepository.findAll() ;
	}

}
