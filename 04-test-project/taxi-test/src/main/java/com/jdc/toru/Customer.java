package com.jdc.toru;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "customer_tbl")
@SecondaryTable(name = "address_tbl")
@IdClass(Driver.class)
public class Customer {
	
//	@Id
//	private int id;
	
	@Column(length = 45,nullable = false)
	private String name;
	
	@Temporal(TemporalType.DATE)
	private Date createAt;
	
	@Column(table = "address_tbl")
	private String state;
	@Column(table = "address_tbl")
	private String township;
	@Column(table = "address_tbl")
	private String street;
	
	@Id
	private String driver_name;
	@Id
	private String nrc;
}
