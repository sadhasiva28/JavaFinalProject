package com.dedal.service;

import java.util.List;

import com.dedal.entity.Doctor;

public interface DoctorInterfaceService {
	
	public Doctor addDoctor(Doctor doctor);
	public List<Doctor> listAllDoctor();

}
