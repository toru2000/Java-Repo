package com.jdc.toru;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.Table;

@Entity
@Table(name = "contact_tbl")
public class Contact{
	
	@Id
	private int id;
	
	@Enumerated(EnumType.STRING)
	private Type type;
	
	public enum Type{
		HOME,PERSON,WORK
	}
	
	@Column(name = "customer_phone")
	private String phone;
	
	@Column(unique = true)
	private String email;
	
	
	

}
