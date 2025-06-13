package com.jdc.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;        //16bits
	
	@Column(length = 45,nullable = false,unique = true)
	private String name;
	
	//@Enumerated
	@Enumerated(EnumType.ORDINAL)        //Enum moh -> tinyint
	private Size size;
	
	@Temporal(TemporalType.DATE)    //date thone chin yin date
	private Date dob;               //java.util ka date yaw time yaw pr loh 
	
	private LocalDateTime createdAt;  //ko yay tae a paw mu ti htwt
	
	@Transient                //persistence -> java bat mhr pe shi pee db mhr column a nay nae ma pr say chin tae hr
	private String note;
	
}
