package com.jdc.toru.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class SaleDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	//customize join table ka kyite tr twy hte loh ya lr
	private int qty;
	private double total;
	
	@ManyToOne
	private Sales sales;
	
	@ManyToOne
	private Product product;

}
