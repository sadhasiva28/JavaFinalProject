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
@Table(name = "atbl_local")
public class LocalTour {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long localid;
	
	@Column(nullable = false)
	private String location;
	
	@Column(nullable = false)
	private long noofpeople;	

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="travellercode", referencedColumnName="travellerId")
	private Traveller trtourist;
}