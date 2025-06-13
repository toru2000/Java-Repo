package com.jdc.entity;

import java.time.LocalDate;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@IdClass(HumanPk.class)
@Table(name = "human_tbl")
public class Human {
	
//	@EmbeddedId
//	private HumanPk id;
	
	private String name;
	private Type type;
	
	@Id
	private String nrc;
	@Id
	private LocalDate dob;
	
	public enum Type{
		STUDENT,EMPLOYEE;
	}

}
