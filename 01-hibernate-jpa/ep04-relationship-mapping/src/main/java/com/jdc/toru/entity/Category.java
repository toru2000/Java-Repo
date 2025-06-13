package com.jdc.toru.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false,length = 45)
	private String name;
	
	
//	@OneToMany
//	@JoinColumn(name = "cat_id")
	/*
	 * when use join column , 
	 * foreign key column will generate on product table 
	 */
	@OneToMany(mappedBy = "category")
	private List<Product> product;

	private boolean active;
}
