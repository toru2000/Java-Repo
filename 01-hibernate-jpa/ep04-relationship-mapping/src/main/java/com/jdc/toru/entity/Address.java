package com.jdc.toru.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

@Data
@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String state;
	
	@Column(nullable = false)
	private String township;
	
	@Column(nullable = false)
	private String address;
	
//	@OneToOne
//	@JoinTable(name = "Address_customer_tbl",
//	joinColumns = {
//			@JoinColumn(name = "add_id")
//	},inverseJoinColumns = {
//			@JoinColumn(name = "cust_id")
//	})
	@OneToOne //foreign key ka Address hte sout "Customer_id"
	@PrimaryKeyJoinColumn
	private Customer customer; //customer ma shi pe address shi loh ma ya
}
