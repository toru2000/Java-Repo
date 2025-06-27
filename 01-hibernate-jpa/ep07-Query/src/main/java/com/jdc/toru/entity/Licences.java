package com.jdc.toru.entity;

import java.time.LocalDate;
import java.util.UUID;

import com.jdc.toru.listeners.EnableTimesListener;
import com.jdc.toru.listeners.Times;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "licences_tbl")
public class Licences implements EnableTimesListener{
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	private LocalDate dob;
	
	private String LicenceNumber;
	
	private LocalDate issueDate;
	private LocalDate validDate;
	
	@Enumerated(EnumType.STRING)
	private LicenceType licenceType;
	
	@Enumerated(EnumType.STRING)
	private BloodType bloodType;
	
	@Embedded 
	private Times times;
	
	@OneToOne(mappedBy = "licences")
	private Drivers drivers;
	
	public enum BloodType{
		A,AB,B,O
	}
	
	public enum LicenceType{
		A,B,C,D,E
	}
	
}
