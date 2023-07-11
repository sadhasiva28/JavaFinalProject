package com.dedal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dedal.entity.Patient;

@Repository
public interface Patientrepository extends CrudRepository<Patient, Long>{

}
