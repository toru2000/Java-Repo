package com.jdc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MapKeyClass;
import jakarta.persistence.OneToOne;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@Enumerated(EnumType.STRING)
	private Type type;
		
	public enum Type{
		GOLD,DIAMOND,PLATINUM
	};
	
	@OneToOne(mappedBy = "customer")
	private Address address;
}
