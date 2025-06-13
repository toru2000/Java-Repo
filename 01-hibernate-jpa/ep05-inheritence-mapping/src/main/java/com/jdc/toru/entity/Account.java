package com.jdc.toru.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
//@MappedSuperclass //parent ma pr //parent si ka field  ya tae child twy htwt lr
@Entity        //parent tbl pe htwt pee kyan tae child ma pr lr
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) //SINGLE_TABLE ka default
public abstract class Account {
	
	@Id
	@Column(length = 30)
	private String email;
	
	@Column(nullable = false,unique = true,length = 30)
	private String username;
	
	@Column(nullable = false,length = 30)
	private int password;
	
	@Enumerated(EnumType.STRING)
	private AccountType accountType;
	
	private LocalDate createDateAt;
	
	private LocalTime createTimeAt;
	
	public enum AccountType{
		EMPLOYEE,MANAGER,CUSTOMER
	}
}
