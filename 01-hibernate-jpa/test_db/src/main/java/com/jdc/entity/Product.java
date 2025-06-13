package com.jdc.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	private boolean active;
	
	@Enumerated(EnumType.STRING)
	private Size size;
	
	public enum Size{
		SMALL,MEDIUM,LARGE
	};
	
	@ManyToOne
	private Category category;
}
