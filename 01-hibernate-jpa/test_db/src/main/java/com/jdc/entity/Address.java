package com.jdc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String state;
	private String address;
	
	
	//@JoinColumn(name = "cust_id")
//	@JoinTable(name = "Address_customer_tbl",joinColumns = {
//			@JoinColumn(name = "add_id")
//	},inverseJoinColumns = {
//			@JoinColumn(name = "cust_id")
//	})
	@OneToOne
	private Customer customer;

}
