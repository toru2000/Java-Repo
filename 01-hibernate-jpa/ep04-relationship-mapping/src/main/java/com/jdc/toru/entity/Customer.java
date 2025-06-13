package com.jdc.toru.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false , length = 45)
	private String name;
	
	@Enumerated(EnumType.STRING)
	private Type memberType;
	
	public enum Type{
		SILVER,GOLD,DIAMOND
	}
	
	//foreign key ka customer hte sout "address_id" //adress hte fk shi thint //adress sout tae a kar customer ya mhr moh
	//address hte fk shi ya mhr moh /customer ko map by ya mal
	@OneToOne(mappedBy = "customer")
	private Address address;

}
