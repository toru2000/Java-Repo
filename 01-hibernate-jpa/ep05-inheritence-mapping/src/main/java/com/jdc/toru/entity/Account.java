package com.jdc.toru.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import com.jdc.toru.entity.converters.StringConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Converter;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.Getter;

@Data
//@MappedSuperclass //parent ma pr //parent si ka field  ya tae child twy htwt lr
@Entity        //parent tbl pe htwt pee kyan tae child ma pr lr
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //SINGLE_TABLE ka default
@DiscriminatorColumn(
		name = "entityName",
		discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue("1")
public abstract class Account {
	
	@Id
	@Column(length = 30)
	private String email;
	
	@Column(nullable = false,unique = true,length = 30)
	private String username;
	
	@Column(nullable = false,length = 30)
	private String password;
	
	@Enumerated(EnumType.STRING)
	private AccountType accountType;
	
	private LocalDate createDateAt;
	
	private LocalTime createTimeAt;
	
	@Convert(converter = StringConverter.class)
	private String value;
	
	public enum AccountType{
		EMPLOYEE,MANAGER,CUSTOMER
	}
}
