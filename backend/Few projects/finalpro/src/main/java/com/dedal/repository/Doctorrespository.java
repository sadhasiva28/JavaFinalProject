package com.dedal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dedal.entity.Doctor;

@Repository
public interface Doctorrespository extends CrudRepository<Doctor, Long>{

}
