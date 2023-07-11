package com.dedal.service;

import java.util.List;

import com.dedal.entity.Patient;

public interface PatientService {
	
	public Patient addPatient(Patient patient);
	public List<Patient> listAllPatient();

}
