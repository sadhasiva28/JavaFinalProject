package com.dedal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dedal.entity.Appointment;

@Repository
public interface Appointmentrespository extends CrudRepository<Appointment, Long> {

}
