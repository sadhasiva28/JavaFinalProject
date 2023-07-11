package com.dedal.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Appointment {
	
	@Id
	@Column(nullable = false)
	private long patientId;
	
	
	@Column(name = "patient_name")
	private String patientname;
	
	@Column(nullable = false)
	private long doctorId;
	
	@Column(name = "doctor_name")
	private String doctorName;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date createdDate;
	
	@PrePersist
	protected void onCreate() {
		createdDate = new Date();
	}
	
	

	
	
	

}
