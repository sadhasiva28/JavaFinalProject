package com.dedal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dedal.entity.Doctor;
import com.dedal.repository.Doctorrespository;

@Service
public class DoctorClassService implements DoctorInterfaceService{

	
	@Autowired
	Doctorrespository doctorrespository;
	
	@Override
	public Doctor addDoctor(Doctor doctor) {

		return doctorrespository.save(doctor);
	}

	@Override
	public List<Doctor> listAllDoctor() {
		return (List<Doctor>) doctorrespository.findAll();
	}

}
