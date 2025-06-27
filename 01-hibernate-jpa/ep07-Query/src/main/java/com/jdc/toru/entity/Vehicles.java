package com.jdc.toru.entity;

import java.util.UUID;

import com.jdc.toru.listeners.EnableTimesListener;
import com.jdc.toru.listeners.Times;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "vehicles_tbl")
public class Vehicles implements EnableTimesListener{
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column(nullable = false,length = 12,unique = true)
	private String carLicence;
	
	@Column(nullable = false)
	private String carModel;
	
	@Embedded
	private Times times;
	
	@Enumerated(EnumType.STRING)
	private Size size;
	
	public enum Size{
		SMALL,MEDIUM,LARGE
	}
}
