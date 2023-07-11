package com.dal.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
@Table(name = "atbl_foreign")
public class ForeignTour {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long foreignId;

	@Column(nullable = false)
	private String country;

	@Column(nullable = false)
	private long noofpeople;

	@Column(nullable = false)
	private boolean isPassportValid;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "travellercode", referencedColumnName = "travellerId")
	private Traveller trtourist;

}

