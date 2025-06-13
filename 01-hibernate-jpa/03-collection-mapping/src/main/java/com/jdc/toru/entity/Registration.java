package com.jdc.toru.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Registration implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private LocalDate registredAt;
	private LocalDate validAt;
	
	
//	@ElementCollection
//	List<String> tests;
}

